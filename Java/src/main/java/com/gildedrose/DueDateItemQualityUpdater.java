package com.gildedrose;

public class DueDateItemQualityUpdater implements QualityUpdater {
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
}
