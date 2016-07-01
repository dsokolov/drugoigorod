package me.ilich.drugoigorod.data;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.ilich.drugoigorod.AssertsTools;
import ru.drugoigorod.app.data.Article;
import ru.drugoigorod.app.data.ArticleParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
            Article article = parser.parse(null);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException);
        }
    }

    @Test
    public void parseEmpty() {
        try {
            Article article = parser.parse("");
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException);
        }
    }

    @Test
    public void parseGrusha1990() {
        try {
            Article article = parser.parse(AssertsTools.asString(context, "articles/grushafest1990.html"));
            assertNotNull(article);
            assertTrue(article.getId().contains("grushafest1990"));
            assertEquals("Грушинские фестивали 1990-х годов в 27 фотографиях", article.getTitle());
        } catch (Exception e) {
            assertTrue(false);
        }
    }

}
