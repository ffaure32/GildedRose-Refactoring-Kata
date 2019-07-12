package com.gildedrose.updater;

import com.gildedrose.Item;

public class AgingWellItemUpdater implements ItemUpdater {
    @Override
    public void updateQuality(Item item) {
        item.increaseQualityIfNotMax();
        if (item.sellIn <= 0) {
            item.increaseQualityIfNotMax();
        }

    }
}
