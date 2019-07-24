package com.gildedrose;

public class CheeseQualityUpdater implements ItemUpdater {
    @Override
    public void updateQuality(Item cheese) {
        cheese.increaseQualityIfNotMax();
        if (cheese.getSellIn() <= 0) {
            cheese.increaseQualityIfNotMax();
        }
    }
}
