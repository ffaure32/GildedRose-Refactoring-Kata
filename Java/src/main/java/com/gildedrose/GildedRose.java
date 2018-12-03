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
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                    break;
                case BACKSTAGE_PASSES:
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;

                        if (item.sellIn <= 10) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn <= 5) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                    break;
                case SULFURAS_HAND_OF_RAGNAROS:
                    break;
                default:
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                    break;
            }

            if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            } else {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                switch (item.name) {
                    case AGED_BRIE:
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                        break;
                    case BACKSTAGE_PASSES:
                        item.quality = 0;
                        break;
                    case SULFURAS_HAND_OF_RAGNAROS:
                        continue;
                    default:
                        if (item.quality > 0) {
                            item.quality = item.quality - 1;
                        }
                        break;
                }
            }
        }
    }
}