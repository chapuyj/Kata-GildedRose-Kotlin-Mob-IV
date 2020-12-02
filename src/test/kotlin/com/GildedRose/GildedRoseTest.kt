package com.GildedRose

import org.junit.Assert.*
import org.junit.Test
import org.assertj.core.api.Assertions.*;

class GildedRoseTest {

    @Test fun should_update_after_day_one() {
        val result = updateItemsUntilDay(1)

        assertThat(result).isEqualTo(
            """
            +5 Dexterity Vest, 9, 19
            Aged Brie, 1, 1
            Elixir of the Mongoose, 4, 6
            Sulfuras, Hand of Ragnaros, 0, 80
            Sulfuras, Hand of Ragnaros, -1, 80
            Backstage passes to a TAFKAL80ETC concert, 14, 21
            Backstage passes to a TAFKAL80ETC concert, 9, 50
            Backstage passes to a TAFKAL80ETC concert, 4, 50
            """.trimIndent()
        )
    }

    @Test fun should_update_after_day_two() {
        val result = updateItemsUntilDay(2)

        assertThat(result).isEqualTo(
            """
            +5 Dexterity Vest, 8, 18
            Aged Brie, 0, 2
            Elixir of the Mongoose, 3, 5
            Sulfuras, Hand of Ragnaros, 0, 80
            Sulfuras, Hand of Ragnaros, -1, 80
            Backstage passes to a TAFKAL80ETC concert, 13, 22
            Backstage passes to a TAFKAL80ETC concert, 8, 50
            Backstage passes to a TAFKAL80ETC concert, 3, 50
            """.trimIndent()
        )
    }

    @Test fun should_update_after_day_100() {
        val result = updateItemsUntilDay(100)

        assertThat(result).isEqualTo(
            """
            +5 Dexterity Vest, -90, 0
            Aged Brie, -98, 50
            Elixir of the Mongoose, -95, 0
            Sulfuras, Hand of Ragnaros, 0, 80
            Sulfuras, Hand of Ragnaros, -1, 80
            Backstage passes to a TAFKAL80ETC concert, -85, 0
            Backstage passes to a TAFKAL80ETC concert, -90, 0
            Backstage passes to a TAFKAL80ETC concert, -95, 0
            """.trimIndent()
        )
    }

    @Test fun should_update_until_day_1000() {         
        val gildedRoseLegacy = GildedRose(fakeItems())
        val newGildedRose = NewGildedRose(fakeItems())

        for (i in 1..1000) {
            gildedRoseLegacy.updateQuality()
            newGildedRose.updateQuality()

            assertThat(gildedRoseLegacy.items.joinToString()).isEqualTo(newGildedRose.items.joinToString())
        }
    }

    @Test fun should_update_conjured_mana_cake() {
        val newGildedRose = NewGildedRose(arrayOf(Item("Conjured Mana Cake", 5, 7)))
        newGildedRose.updateQuality()

        assertThat(newGildedRose.items.joinToString()).isEqualTo("Conjured Mana Cake, 4, 5")
    }

    @Test fun should_update_conjured_mana_cake_when_sell_in_is_negative() {
        val newGildedRose = NewGildedRose(arrayOf(Item("Conjured Mana Cake", 0, 7)))
        newGildedRose.updateQuality()

        assertThat(newGildedRose.items.joinToString()).isEqualTo("Conjured Mana Cake, -1, 3")
    }

    private fun updateItemsUntilDay(day: Int) : String {      
        val items = fakeItems()            
        val app = GildedRose(items)

        for (i in 1..day) {
            app.updateQuality()
        }
        
        return app.items.joinToString(separator = "\n")
    }

    private fun fakeItems() = arrayOf(
            Item("+5 Dexterity Vest", 10, 20),
            Item("Aged Brie", 2, 0),
            Item("Elixir of the Mongoose", 5, 7),
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        )
}