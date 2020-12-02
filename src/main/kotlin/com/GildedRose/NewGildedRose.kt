package com.GildedRose

class NewGildedRose(var items: Array<Item>) {

    companion object {
        const val AGED_BRIE = "Aged Brie"
        const val BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert"
        const val SULFURAS = "Sulfuras, Hand of Ragnaros"
        const val CONJURED_MANA_CAKE = "Conjured Mana Cake"
    }

    fun updateQuality() = items.forEach { updateItemQuality(it) }


    private fun updateItemQuality(item: Item) {
        when (item.name) {
            SULFURAS -> return
            AGED_BRIE -> updateAgedBrie(item)
            BACKSTAGE_PASS -> updateBackstagePasses(item)
            CONJURED_MANA_CAKE -> updateConjuredManaCake(item)
            else -> updateDefault(item)
        }
    }

    private fun updateConjuredManaCake(item: Item) = updateDefault(item, 2)

    private fun updateBackstagePasses(item: Item) {
        if (item.quality < 50) {
            item.increaseQuality()

            if (item.sellIn < 11) {
                item.increaseQuality()
                if (item.sellIn < 6) {
                    item.increaseQuality()
                }
            }
        }

        item.decreaseSellIn()

        if (item.sellIn < 0) {
            item.quality = 0
        }
    }

    private fun updateAgedBrie(item: Item) {
        item.increaseQuality()

        item.decreaseSellIn()

        if (item.sellIn < 0) {
            item.increaseQuality()
        }
    }

    private fun updateDefault(item: Item, factor: Int = 1) {
        item.decreaseQuality(factor)

        item.decreaseSellIn()

        if (item.sellIn < 0) {
            item.decreaseQuality(factor)
        }
    }
}

fun Item.increaseQuality(factor: Int = 1) {
    if (quality >= 50) return
    quality += factor
}

fun Item.decreaseQuality(factor: Int = 1) {
    if (quality <= 0) return
    quality -= factor
}

fun Item.decreaseSellIn() {
    sellIn -= 1
}