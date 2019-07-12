package com.gildedrose.updater;

import com.gildedrose.Item;

public interface ItemUpdater {
    void updateQuality(Item oldBrie);

    default void updateSellIn(Item item) {
        item.decreaseSellIn();
    }
}
