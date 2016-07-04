package me.ilich.drugoigorod.data;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import ru.drugoigorod.app.data.Article;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class ArticleTest {

    @Test
    public void getters() {
        Article article = new Article.ArticleBuilder()
                .setId("id")
                .setTitle("title")
                .setDescription("description")
                .setAuthor("author")
                .setViews(123)
                .setPublichDateTime("publish date time")
                .setCategoryTitle("category")
                .setHeaderImageUrl("header url")
                .setHeaderBackgroundColor("color")
                .setContent("content")
                .build();
        assertEquals("id", article.getId());
        assertEquals("title", article.getTitle());
        assertEquals("description", article.getDescription());
        assertEquals("author", article.getAuthor());
        assertEquals(123, article.getViewsCount());
        assertEquals("publish date time", article.getPublishDateTime());
        assertEquals("category", article.getCategoryTitle());
        assertEquals("header url", article.getHeaderImageUrl());
        assertEquals("color", article.getHeaderBackgroundColor());
        assertEquals("content", article.getContent());
    }

}
