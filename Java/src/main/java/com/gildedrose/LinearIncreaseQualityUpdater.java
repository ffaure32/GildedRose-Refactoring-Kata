package com.gildedrose;

public class LinearIncreaseQualityUpdater implements QualityUpdater {
    @Override
    public void updateQuality(Item item) {
        item.increaseQualityIfNotMax();
    }
}
