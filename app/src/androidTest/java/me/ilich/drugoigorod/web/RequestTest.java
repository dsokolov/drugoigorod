package me.ilich.drugoigorod.web;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.drugoigorod.app.web.Request;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RequestTest {

    @Test
    public void requestNull() {
        try {
            new Request(null);
            assertTrue(false);
        } catch (NullPointerException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void requestEmpty() {
        try {
            new Request("");
            assertTrue(false);
        } catch (NullPointerException e) {
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void requestYaru() {
        try {
            String s = new Request("https://ya.ru").request();
            assertFalse(TextUtils.isEmpty(s));
            assertTrue(s.contains("yandex"));
        } catch (Exception e) {
            assertTrue(e.getMessage(), false);
        }
    }

}
