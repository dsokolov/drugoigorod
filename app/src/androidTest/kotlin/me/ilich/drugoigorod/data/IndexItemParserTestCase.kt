package me.ilich.drugoigorod.data

import android.content.Context
import android.graphics.Color
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
import ru.drugoigorod.app.data.IndexItem.Style

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
                IndexItem(
                        "http://drugoigorod.ru/go-to-metafest/",
                        "ТЕМА ЛЕТА",
                        "http://drugoigorod.ru/wp-content/uploads/2016/07/концерт-11.jpg",
                        Style.BIG,
                        Color.parseColor("#FFFFFF"),
                        Color.parseColor("#808080")
                ),
                IndexItem(
                        "http://drugoigorod.ru/uber-samara-26-07-16/",
                        "ШЕФ, ТРОГАЙ!",
                        "http://drugoigorod.ru/wp-content/uploads/2016/07/tumblr_njbu28if9v1qd479ro1_1280.gif",
                        Style.NORMAL,
                        Color.parseColor("#FFFFFF"),
                        Color.parseColor("#808080")
                ),
                IndexItem(
                        "http://drugoigorod.ru/metafest_activities/",
                        "ЧТО ДУШЕ УГОДНО",
                        "http://drugoigorod.ru/wp-content/uploads/2016/07/pA09wik0ke8.jpg",
                        Style.NORMAL,
                        Color.parseColor("#FFFFFF"),
                        Color.parseColor("#808080")
                ),
                IndexItem(
                        "http://drugoigorod.ru/tsf2016-online/",
                        "ВОЗВРАЩЕНИЕ ЦВЕТА",
                        "http://drugoigorod.ru/wp-content/uploads/2016/06/xgDzirkb35A-728x483.jpg",
                        Style.NORMAL,
                        Color.parseColor("#FFFFFF"),
                        Color.parseColor("#808080")
                ),
                IndexItem(
                        "http://drugoigorod.ru/allprivileges/",
                        "ВСЁ МОГУТ КОРОЛИ",
                        "http://drugoigorod.ru/wp-content/uploads/2016/07/luxury_lifestyle-wallpaper-1152x720-773x483.jpg",
                        Style.NORMAL,
                        Color.parseColor("#FFFFFF"),
                        Color.parseColor("#808080")
                ),
                IndexItem(
                        "http://drugoigorod.ru/street_music/",
                        "МАМА АНАРХИЯ",
                        "http://drugoigorod.ru/wp-content/uploads/2016/07/ivan2.jpg",
                        Style.NORMAL,
                        Color.parseColor("#FFFFFF"),
                        Color.parseColor("#808080")
                ),
                IndexItem(
                        "http://drugoigorod.ru/halyava-2507-3107/",
                        "ВХОД СВОБОДНЫЙ",
                        "http://drugoigorod.ru/wp-content/uploads/2016/07/gimage_842_новый-размер1-675x483.jpg",
                        Style.NORMAL,
                        Color.parseColor("#FFFFFF"),
                        Color.parseColor("#808080")
                )
        )
        assertArrayEquals(expected.toTypedArray(), parsed?.toTypedArray())
    }

}