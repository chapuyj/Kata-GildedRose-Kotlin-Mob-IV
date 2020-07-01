package com.GildedRose

class NewGildedRose(var items: Array<Item>) {

    companion object {
        const val AGED_BRIE = "Aged Brie"
        const val BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert"
        const val SULFURAS = "Sulfuras, Hand of Ragnaros"
        const val CONJURED_MANA_CAKE = "Conjured Mana Cake"
    }


    fun updateQuality() {
        items.forEach { updateItemQuality(it) }
    }

    private fun updateItemQuality(item: Item) {
        when (item.name) {
            SULFURAS -> return

            AGED_BRIE -> {
                if (item.quality < 50) {
                    increaseQuality(item)
                }

                decreaseSellIn(item)

                if (item.sellIn < 0) {
                    if (item.quality < 50) {
                        increaseQuality(item)
                    }
                }
            }
            BACKSTAGE_PASS -> {
                if (item.quality < 50) {
                    increaseQuality(item)

                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            increaseQuality(item)
                        }
                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                increaseQuality(item)
                            }
                        }
                    }
                }

                decreaseSellIn(item)

                if (item.sellIn < 0) {
                    item.quality = 0
                }
            }
            else -> {
                if (item.quality > 0) {
                    decreaseQuality(item)
                }

                decreaseSellIn(item)

                if (item.sellIn < 0) {
                    if (item.quality > 0) {
                        decreaseQuality(item)
                    }
                }
            }
        }
    }

    private fun decreaseSellIn(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    private fun decreaseQuality(item: Item) {
        item.quality = item.quality - 1
    }

    private fun increaseQuality(item: Item) {
        item.quality = item.quality + 1
    }
}