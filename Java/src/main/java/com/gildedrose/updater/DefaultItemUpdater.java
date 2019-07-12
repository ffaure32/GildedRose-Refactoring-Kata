package com.gildedrose.updater;

import com.gildedrose.Item;

public class DefaultItemUpdater implements ItemUpdater {
    @Override
    public void updateQuality(Item item) {
        item.decreaseQualityIfNotMin();
        if (item.sellIn <= 0) {
            item.decreaseQualityIfNotMin();
        }
    }
}
