package me.ilich.drugoigorod.data;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.ilich.drugoigorod.AssertsTools;
import ru.drugoigorod.app.data.Article;
import ru.drugoigorod.app.data.ArticleParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class ArticleParserTest {

    private ArticleParser parser;
    private Context context;

    @Before
    public void setup() {
        context = InstrumentationRegistry.getInstrumentation().getContext();
        parser = new ArticleParser();
    }

    @Test
    public void parseNull() {
        try {
            parser.parse(null);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException);
        }
    }

    @Test
    public void parseEmpty() {
        try {
            parser.parse("");
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException);
        }
    }

    @Test
    public void parseGrushafest1990() {
        try {
            Article article = parser.parse(AssertsTools.asString(context, "articles/grushafest1990.html"));
            assertNotNull(article);
            assertEquals("http://drugoigorod.ru/grushafest1990/", article.getId());
            assertEquals("САМАРА 2.0", article.getTitle());
            assertEquals("Грушинские фестивали 1990-х годов в 27 фотографиях", article.getDescription());
            assertEquals("1 039", article.getViewsCount());
            assertEquals("Андрей Артёмов", article.getAuthor());
            assertEquals("30 ИЮНЯ 2016, 12:37", article.getPublishDateTime());
            assertEquals("ИСТОРИИ", article.getCategoryTitle());
            assertEquals("http://drugoigorod.ru/wp-content/uploads/2016/06/дг-9571.jpg", article.getHeaderImageUrl());
            assertEquals("121, 63, 152, 0.5", article.getHeaderBackgroundColor());
            assertFalse(TextUtils.isEmpty(article.getContent()));
            assertTrue(article.getContent().contains("Первый блок фотографий будет посвящён главным действующим лицам"));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void parseBloodwork() {
        try {
            Article article = parser.parse(AssertsTools.asString(context, "articles/bloodwork.html"));
            assertNotNull(article);
            assertEquals("http://drugoigorod.ru/bloodwork-16/", article.getId());
            assertEquals("БИЗНЕС НА КРОВИ", article.getTitle());
            Log.v("title", "parseBloodwork: "+ article.getTitle());
            assertEquals("Проверяем работу частных самарских лабораторий по приёму анализов", article.getDescription());
            assertEquals("1 127", article.getViewsCount());
            assertEquals("Антон Черепок", article.getAuthor());
            assertEquals("29 ИЮНЯ 2016, 14:39", article.getPublishDateTime());
            assertEquals("", article.getCategoryTitle());
            assertEquals("http://drugoigorod.ru/wp-content/uploads/2016/06/krov_1.jpg", article.getHeaderImageUrl());
            assertEquals("204, 61, 61, 0.5", article.getHeaderBackgroundColor());
            assertFalse(TextUtils.isEmpty(article.getContent()));
            assertTrue(article.getContent().contains("Кабинет “Пробир-ки” находится в переоборудованной квартире"));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
