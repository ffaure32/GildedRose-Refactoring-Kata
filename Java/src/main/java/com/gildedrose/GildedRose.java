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
                if (item.sellIn <= 0) {
                    item.increaseQualityIfNotMax();
                }
                item.decreaseSellIn();
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                item.increaseQualityIfNotMax();
                if (item.sellIn < 11) {
                    item.increaseQualityIfNotMax();
                }
                if (item.sellIn < 6) {
                    item.increaseQualityIfNotMax();
                }
                if (item.sellIn <= 0) {
                    item.quality = 0;
                }
                item.decreaseSellIn();
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                item.decreaseQualityIfNotMin();
                if (item.sellIn <= 0) {
                    item.decreaseQualityIfNotMin();
                }
                item.decreaseSellIn();
                break;
        }
    }

}