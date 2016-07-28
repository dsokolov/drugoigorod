package ru.drugoigorod.app.data

import java.util.regex.Pattern

class IndexItemParser : Parser<List<IndexItem>>() {

    val pattern = Pattern.compile("<div class=\"span12 column_container\" >(.*?)</div>");

    override fun onParse(s: String): List<IndexItem> {
        val l = mutableListOf<IndexItem>()
        val innerString = parse(s, pattern)
        return l
    }

}

