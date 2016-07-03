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
        Article article = new Article.ArticleBuilder().build();
        assertEquals("id", article.getId());
        assertEquals("title", article.getTitle());
        assertEquals("content", article.getContent());
        assertEquals("description", article.getDescription());
        assertEquals("author", article.getAuthor());
        assertEquals(0, article.getViews());
    }

}
