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
            updateQuality(item);
            updateSellin(item);
            if (item.sellIn < 0) {
                updateQualityAfterSellin(item);
            }
        }
    }

    private void updateQualityAfterSellin(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                item.updateQualityIfNotMax();
                break;
            case BACKSTAGE_PASSES:
                item.quality = 0;
                break;
            case SULFURAS_HAND_OF_RAGNAROS:
                break;
            default:
                item.decreaseQualityIfNotMin();
                break;
        }
    }

    private void updateSellin(Item item) {
        if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
        } else {
            item.decreaseSellIn();
        }
    }

    private void updateQuality(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                item.updateQualityIfNotMax();
                break;
            case BACKSTAGE_PASSES:
                item.updateQualityIfNotMax();

                if (item.sellIn < 11) {
                    item.updateQualityIfNotMax();
                }

                if (item.sellIn < 6) {
                    item.updateQualityIfNotMax();
                }
                break;
            case SULFURAS_HAND_OF_RAGNAROS:
                break;
            default:
                item.decreaseQualityIfNotMin();
                break;
        }
    }

}