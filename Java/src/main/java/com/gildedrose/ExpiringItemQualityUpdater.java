package com.gildedrose;

public class ExpiringItemQualityUpdater implements ItemUpdater {
    @Override
    public void updateQuality(Item cheese) {
        cheese.increaseQualityIfNotMax();
        if (cheese.getSellIn() <= 10) {
            cheese.increaseQualityIfNotMax();
        }
        if (cheese.getSellIn() <= 5) {
            cheese.increaseQualityIfNotMax();
        }
        if (cheese.getSellIn() <= 0) {
            cheese.resetQuality();
        }
    }
}
