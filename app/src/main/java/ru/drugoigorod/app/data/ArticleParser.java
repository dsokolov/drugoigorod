package ru.drugoigorod.app.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArticleParser extends Parser<Article> {

    private static Pattern idPattern = Pattern.compile("<link rel='canonical' href='(.*?)' />");
    private static Pattern descriptionPattern = Pattern.compile("<p class=\"index-mainpic-bigtitl\">(.*?)</p>");
    private static Pattern authorPattern = Pattern.compile("<meta name=\'author\' content=\'(.*?)\'>");
    private static Pattern titlePattern = Pattern.compile("<p class=\"index-mainpic-bigsub\">(.*?)</p>");
    private static Pattern viewsPattern = Pattern.compile("/images/eye_views.png>'(.*?)''</nobr></p>'");

    @Override
    protected Article onParse(String s) {

        final String description;
        Matcher descriptionMatcher = descriptionPattern.matcher(s);
        if (descriptionMatcher.find()) {
            description = descriptionMatcher.group(1);
        } else {
            description = "";
        }

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

        final String author;
        Matcher authorMatcher = authorPattern.matcher(s);
        if (authorMatcher.find()) {
            author = authorMatcher.group(1);
        } else {
            author = "";
        }


        String content = "";

        final String views;
        Matcher viewsMatcher = viewsPattern.matcher(s);
        if (authorMatcher.find()) {
            views = viewsMatcher.group(1);
        } else {
            views = "";
        }




        return new Article.ArticleBuilder().setId(id).setTitle(title).setAuthor(author).setContent(content)
                .setDescription(description).setViews(views).build();
    }

}
