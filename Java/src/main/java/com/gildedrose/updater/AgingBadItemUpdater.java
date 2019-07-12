package com.gildedrose.updater;

import com.gildedrose.Item;

public class AgingBadItemUpdater implements ItemUpdater {
    @Override
    public void updateQuality(Item item) {
        item.decreaseQualityIfNotMin();
        item.decreaseQualityIfNotMin();
        if (item.sellIn <= 0) {
            item.decreaseQualityIfNotMin();
            item.decreaseQualityIfNotMin();
        }

    }
}
