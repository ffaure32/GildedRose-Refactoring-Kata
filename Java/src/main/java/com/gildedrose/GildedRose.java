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
            if (item.name.equals(AGED_BRIE)) {
                updateQualityIfNotMax(item);
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                updateQualityIfNotMax(item);

                if (item.sellIn < 11) {
                    updateQualityIfNotMax(item);
                }

                if (item.sellIn < 6) {
                    updateQualityIfNotMax(item);
                }
            } else {
                if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                } else {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                }
            }

            if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            } else {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (item.name.equals(AGED_BRIE)) {
                    updateQualityIfNotMax(item);
                } else {
                    if (item.name.equals(BACKSTAGE_PASSES)) {
                        item.quality = 0;
                    } else {
                            if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                                continue;
                            }
                        if (item.quality > 0) {
                            item.quality = item.quality - 1;
                        }
                    }
                }
            }
        }
    }

    private void updateQualityIfNotMax(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}