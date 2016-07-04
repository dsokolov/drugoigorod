package ru.drugoigorod.app.web;

public class ArticleRequest extends Request {

    private static final String URL_PATTERN = "http://drugoigorod.ru/%s/";

    public ArticleRequest(String articleId) {
        super(String.format(URL_PATTERN, articleId));
    }

}
