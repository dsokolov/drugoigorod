package me.ilich.drugoigorod.web;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;
import android.util.Log;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.drugoigorod.app.data.Article;
import ru.drugoigorod.app.data.ArticleParser;
import ru.drugoigorod.app.web.ArticleRequest;
import ru.drugoigorod.app.web.Request;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ArticleFullTest {

    ArticleParser parser;

    @Before
    public void setUp() {
        parser = new ArticleParser();
    }

    @Test
    public void bloodWork() {
        try {
            String s = new ArticleRequest("bloodwork-16").request();
            assertFalse(TextUtils.isEmpty(s));
            assertTrue(s.contains("http://drugoigorod.ru/bloodwork-16/"));
            Article article = parser.parse(s);
            assertNotNull(article);
            assertFalse(TextUtils.isEmpty(article.getId()));
            assertTrue(article.getId().contains("bloodwork-16"));
            assertEquals("БИЗНЕС НА КРОВИ", article.getTitle());
            assertEquals("Проверяем работу частных самарских лабораторий по приёму анализов", article.getDescription());
            assertFalse(TextUtils.isEmpty(article.getViewsCount()));
            assertEquals("Антон Черепок", article.getAuthor());
            assertEquals("29 ИЮНЯ 2016, 14:39", article.getPublishDateTime());
            assertEquals("", article.getCategoryTitle());
            assertEquals("http://drugoigorod.ru/wp-content/uploads/2016/06/krov_1.jpg", article.getHeaderImageUrl());
            assertEquals("204, 61, 61, 0.5", article.getHeaderBackgroundColor());
            Assert.assertFalse(TextUtils.isEmpty(article.getContent()));
            Assert.assertTrue(article.getContent().contains("Кабинет “Пробир-ки” находится в переоборудованной квартире"));
        } catch (Request.RequestException e) {
            assertFalse(e.getMessage(), true);
        }
    }

    @Test
    public void grushafest1990() {
        try {
            String s = new ArticleRequest("Grushafest1990").request();
            assertFalse(TextUtils.isEmpty(s));
            assertTrue(s.contains("http://drugoigorod.ru/grushafest1990/"));
            Article article = parser.parse(s);
            assertNotNull(article);
            assertFalse(TextUtils.isEmpty(article.getId()));
            assertTrue(article.getId().contains("grushafest1990"));
            assertEquals("САМАРА 2.0", article.getTitle());
            assertEquals("Грушинские фестивали 1990-х годов в 27 фотографиях", article.getDescription());
            assertFalse(TextUtils.isEmpty(article.getViewsCount()));
            assertEquals("Андрей Артёмов", article.getAuthor());
            assertEquals("30 ИЮНЯ 2016, 12:37", article.getPublishDateTime());
            assertEquals("ИСТОРИИ", article.getCategoryTitle());
            assertEquals("http://drugoigorod.ru/wp-content/uploads/2016/06/дг-9571.jpg", article.getHeaderImageUrl());
            assertEquals("121, 63, 152, 0.5", article.getHeaderBackgroundColor());
            Assert.assertFalse(TextUtils.isEmpty(article.getContent()));
            Assert.assertTrue(article.getContent().contains("Первый блок фотографий будет посвящён главным действующим лицам"));
        } catch (Request.RequestException e) {
            assertFalse(e.getMessage(), true);
        }
    }

}
