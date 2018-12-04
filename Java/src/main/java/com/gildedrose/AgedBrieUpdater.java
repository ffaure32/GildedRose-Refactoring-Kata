package com.gildedrose;

public class AgedBrieUpdater implements ItemUpdater {
    @Override
    public void updateQuality(Item item) {
        item.increaseQualityIfNotMax();
    }

    @Override
    public void updateSellin(Item item) {
        item.decreaseSellin();
    }

    @Override
    public void updateQualityAfterSellin(Item item) {
        item.increaseQualityIfNotMax();
    }
}
