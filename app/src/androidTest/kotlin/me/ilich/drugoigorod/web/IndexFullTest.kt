package me.ilich.drugoigorod.web

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import ru.drugoigorod.app.data.IndexItemParser
import ru.drugoigorod.app.web.IndexRequest

@RunWith(AndroidJUnit4::class)
@LargeTest
class IndexFullTest {

    @Test fun test1() {
        val s = IndexRequest().request()
        assertNotNull(s)
        val items = IndexItemParser().parse(s)
        assertNotNull(items)
        assertTrue(items.size > 0)
    }

}