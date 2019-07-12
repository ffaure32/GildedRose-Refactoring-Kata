package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        switch (item.name) {
            case "Aged Brie":
                item.increaseQualityIfNotMax();
                item.decreaseSellIn();
                if (item.sellIn < 0) {
                    item.increaseQualityIfNotMax();
                }
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                item.increaseQualityIfNotMax();
                if (item.sellIn < 11) {
                    item.increaseQualityIfNotMax();
                }
                if (item.sellIn < 6) {
                    item.increaseQualityIfNotMax();
                }
                item.decreaseSellIn();
                if (item.sellIn < 0) {
                    item.quality = 0;
                }
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                item.decreaseQualityIfNotMin();
                item.decreaseSellIn();
                if (item.sellIn < 0) {
                    item.decreaseQualityIfNotMin();
                }
                break;
        }
    }

}