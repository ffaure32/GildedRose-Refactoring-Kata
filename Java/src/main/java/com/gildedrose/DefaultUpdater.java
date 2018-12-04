package com.gildedrose;

public class DefaultUpdater implements ItemUpdater {
    @Override
    public void updateQuality(Item item) {
        item.decreaseQualityIfNotMin();
    }

    @Override
    public void updateSellin(Item item) {
        item.decreaseSellin();
    }

    @Override
    public void updateQualityAfterSellin(Item item) {
        item.decreaseQualityIfNotMin();
    }
}
