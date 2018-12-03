package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case AGED_BRIE:
                    item.increaseQualityIfNotMax();
                    break;
                case BACKSTAGE_PASSES:
                    item.increaseQualityIfNotMax();
                    if (item.sellIn <= 10) {
                        item.increaseQualityIfNotMax();
                    }
                    if (item.sellIn <= 5) {
                        item.increaseQualityIfNotMax();
                    }
                    break;
                case SULFURAS_HAND_OF_RAGNAROS:
                    break;
                default:
                    item.decreaseQualityIfNotMin();
                    break;
            }

            if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            } else {
                item.decreaseSellin();
            }

            if (item.sellIn < 0) {
                switch (item.name) {
                    case AGED_BRIE:
                        item.increaseQualityIfNotMax();
                        break;
                    case BACKSTAGE_PASSES:
                        item.quality = 0;
                        break;
                    case SULFURAS_HAND_OF_RAGNAROS:
                        continue;
                    default:
                        item.decreaseQualityIfNotMin();
                        break;
                }
            }
        }
    }

}