package com.gildedrose.updater;

import com.gildedrose.Item;

public class DueDateItemUpdater implements ItemUpdater {
    @Override
    public void updateQuality(Item item) {
        item.increaseQualityIfNotMax();
        if (item.sellIn <= 10) {
            item.increaseQualityIfNotMax();
        }
        if (item.sellIn <= 5) {
            item.increaseQualityIfNotMax();
        }
        if (item.sellIn <= 0) {
            item.quality = 0;
        }
    }
}
