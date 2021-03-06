package ru.drugoigorod.app.data

import android.graphics.Color
import android.util.Log
import org.htmlcleaner.HtmlCleaner
import org.htmlcleaner.TagNode
import java.util.regex.Pattern

class IndexItemParser : Parser<List<IndexItem>>() {

    val pattern = Pattern.compile("<div class=\"span12 column_container\" >(.*?)</div>")!!;

    val bigArticlePattern = Pattern.compile("<div (.*?)</div></div>")!!;

    val backgroundUrlPattern = Pattern.compile("background-image:url[(](.*?)[)];")!!

    val urlTitlePattern = Pattern.compile("<a href=\"(.*?)\" style=\"text-decoration:none;color:#fff;\">(.*?)</a>")!!;

    val textColorPatter = Pattern.compile("color:(.*?);(.*?)background-color:(.*?);");

    /*
     * топ
     * за неделю
     * <!-- WordPress Popular Posts Plugin v3.2.1 [PHP] [weekly] [views] [custom] -->
     * <ul class="wpp-list">
     *     <div class='wpp-hr1'> ... </div>
     * </ul>
     *
     * <!-- WordPress Popular Posts Plugin v3.2.1 [PHP] [monthly] [views] [custom] -->
     *
     * <!-- WordPress Popular Posts Plugin v3.2.1 [PHP] [all] [views] [custom] -->
     *
     */

    override fun onParse(s: String): List<IndexItem> {
        val l = mutableListOf<IndexItem>()

        val htmlCleaner = HtmlCleaner()
        val rootNode = htmlCleaner.clean(s)
        val allIndex = rootNode.findElementByAttValue("class", "span12 column_container", true, false);

        val childTags = allIndex.childTagList

        val firstArticle = childTags[0];
        with(firstArticle) {
            parseAndAddItem(l)
        }
        val secondPart = childTags[1]
        for (p in secondPart.childTagList) {
            with(p) {
                val style = getAttributeByName("style")
                val backgroundUrl = parse(style, backgroundUrlPattern)
                val textColor = Color.BLACK //TODO
                val textBackgroundColor = Color.GREEN //TODO
                val articleUrl = p.findElementByName("div", false).findElementByName("a", false).getAttributeByName("href")
                val articleTitle = p.findElementByName("div", false).findElementByName("a", false).text.toString()
                val textStyle = p.findElementByName("div", false).findElementByName("a", false).getAttributeByName("style")
                Log.v("Sokolov", textStyle)
                l.add(IndexItem(articleUrl, articleTitle, backgroundUrl, IndexItem.Style.NORMAL, textColor, textBackgroundColor))
            }
        }

/*        val innerString = parse(s, pattern)
        val bigArticle = Parser.parse(innerString, bigArticlePattern);
        val backgroundUrl = Parser.parse(bigArticle, backgroundUrlPattern); */
        return l
    }

    private fun TagNode.parseAndAddItem(l: MutableList<IndexItem>): Boolean {
        val style = getAttributeByName("style")
        val backgroundUrl = parse(style, backgroundUrlPattern)
        val textColor = Color.BLACK //TODO
        val textBackgroundColor = Color.GREEN //TODO

        val v = findElementByName("div", false).findElementByName("p", false)


        val articleUrl = v.findElementByName("a", false).getAttributeByName("href")
        val articleTitle = v.findElementByName("a", false).text.toString()
        val textStyle = v.findElementByName("a", false).getAttributeByName("style")
        Log.v("Sokolov", textStyle)
        return l.add(IndexItem(articleUrl, articleTitle, backgroundUrl, IndexItem.Style.BIG, textColor, textBackgroundColor))
    }

}

