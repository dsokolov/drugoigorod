package me.ilich.drugoigorod.data

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import me.ilich.drugoigorod.AssertsTools
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.drugoigorod.app.data.IndexItem
import ru.drugoigorod.app.data.IndexItemParser

@RunWith(AndroidJUnit4::class)
@SmallTest
class IndexItemParserTestCase {

    var parser: IndexItemParser? = null
    var context: Context? = null


    @Before fun setUp() {
        context = InstrumentationRegistry.getInstrumentation().context
        parser = IndexItemParser()
    }

    @Test fun testParseIndex() {
        val parsed = parser?.parse(AssertsTools.asString(context, "indexes/index.html"))
        assertNotNull(parsed)
        val expected = listOf<IndexItem>(
                IndexItem("ТЕМА ЛЕТА"),
                IndexItem("ШЕФ, ТРОГАЙ!")
        )
        assertArrayEquals(expected.toTypedArray(), parsed?.toTypedArray())

    }

}