package me.ilich.drugoigorod.web;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.drugoigorod.app.data.Article;
import ru.drugoigorod.app.data.ArticleParser;
import ru.drugoigorod.app.web.ArticleRequest;
import ru.drugoigorod.app.web.Request;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ArticleFullTest {

    ArticleParser parser;

    @Before
    public void setUp() {
        parser = new ArticleParser();
    }

    @Test
    public void requestBloodWork() {
        try {
            String s = new ArticleRequest("bloodwork-16").request();
            assertFalse(TextUtils.isEmpty(s));
            assertTrue(s.contains("http://drugoigorod.ru/bloodwork-16/"));
            Article article = parser.parse(s);
            assertNotNull(article);
            assertEquals("bloodwork-16", article.getId());
        } catch (Request.RequestException e) {
            assertFalse(e.getMessage(), true);
        }
    }

}
