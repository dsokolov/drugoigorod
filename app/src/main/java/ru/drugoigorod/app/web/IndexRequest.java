package ru.drugoigorod.app.web;

public class IndexRequest extends Request {

    private static final String URL_PATTERN = "http://drugoigorod.ru/";

    public IndexRequest() {
        super(URL_PATTERN);
    }

}
