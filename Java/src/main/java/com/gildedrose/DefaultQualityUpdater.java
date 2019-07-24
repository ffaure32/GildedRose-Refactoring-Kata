package com.gildedrose;

public class DefaultQualityUpdater implements ItemUpdater {
    @Override
    public void updateQuality(Item item) {
        item.decreaseQualityIfNotMin();
        if (item.getSellIn() <= 0) {
            item.decreaseQualityIfNotMin();
        }
    }
}
