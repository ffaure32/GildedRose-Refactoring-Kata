package com.gildedrose;

public class BackStageUpdater implements ItemUpdater {
    @Override
    public void updateQuality(Item item) {
        item.increaseQualityIfNotMax();
        if (item.sellIn <= 10) {
            item.increaseQualityIfNotMax();
        }
        if (item.sellIn <= 5) {
            item.increaseQualityIfNotMax();
        }
    }

    @Override
    public void updateSellin(Item item) {
        item.decreaseSellin();
    }

    @Override
    public void updateQualityAfterSellin(Item item) {
        item.quality = 0;
    }
}
