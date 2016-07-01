package ru.drugoigorod.app.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArticleParser extends Parser<Article> {

    private static Pattern titlePattern = Pattern.compile("<p class=\"index-mainpic-bigtitl\">(.*?)</p>");
    private static Pattern idPattern = Pattern.compile("<link rel='canonical' href='(.*?)' />");


    @Override
    protected Article onParse(String s) {

        final String title;
        Matcher titleMatcher = titlePattern.matcher(s);
        if (titleMatcher.find()) {
            title = titleMatcher.group(1);
        } else {
            title = "";
        }

        final String id;
        Matcher idMatcher = idPattern.matcher(s);
        if (idMatcher.find()) {
            id = idMatcher.group(1);
        } else {
            id = "";
        }

        String content = "";

        return new Article(id, title, content);
    }

}
