package ru.drugoigorod.app;


import java.util.ArrayList;
import java.util.List;

public class Article {

    private String title;

    Article(String title) {

        this.title = title;

    }

    private ArrayList<Article> articles;


    public List<Article> initializeData() {
        articles = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            articles.add(new Article(title + i));
        }
        return articles;
    }

}
