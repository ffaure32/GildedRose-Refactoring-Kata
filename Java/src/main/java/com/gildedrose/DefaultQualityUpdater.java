package com.gildedrose;

public class DefaultQualityUpdater implements QualityUpdater {
    @Override
    public void updateQuality(Item item) {
        item.decreaseQualityIfNotMin();
    }
}
