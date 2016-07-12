package ru.drugoigorod.app.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArticleParser extends Parser<Article> {

    private static Pattern idPattern = Pattern.compile("<link rel='canonical' href='(.*?)' />");
    private static Pattern descriptionPattern = Pattern.compile("<p class=\"index-mainpic-bigtitl\">(.*?)</p>");
    private static Pattern authorPattern = Pattern.compile("<meta name=\"author\" content=\"(.*?)\">");
    private static Pattern titlePattern = Pattern.compile("<p class=\"index-mainpic-bigsub\">(.*?)</p>");
    private static Pattern viewsPattern = Pattern.compile("<img border=0 src=\"\\/images\\/eye_views.png\" style=\"margin-left:8px;margin-bottom:4px;margin-right:1px;\">(.*?)<!--old ");
    private static Pattern dateTimePattern = Pattern.compile("class=\"entry-date updated\" datetime=\" \\d{4}-\\d{2}-\\d{2}[Т]\\d{2}:\\d{2}:\\d{2}+\\d{2}:\\d{2} >(.*?)</time>");



    private static String parse(String s, Pattern pattern) {
        final String r;
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            r = matcher.group(1);
        } else {
            r = "";
        }
        return r;
    }

    @Override
    protected Article onParse(String s) {
        final String date = parse(s, dateTimePattern);
        final String description = parse(s, descriptionPattern);
        final String title = parse(s, titlePattern);
        final String id = parse(s, idPattern);
        final String author = parse(s, authorPattern);
        String content = ""; //TODO
        final String views = parse(s, viewsPattern);
        return new Article.ArticleBuilder().setId(id).setTitle(title).setAuthor(author).setContent(content).setDateTime(date)
                .setDescription(description).setViews(views).build();
    }

}
