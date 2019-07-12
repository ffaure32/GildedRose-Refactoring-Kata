package com.gildedrose;

public class FastDegradatingQualityUpdate implements QualityUpdater {
    @Override
    public void updateQuality(Item item) {
        item.decreaseQualityIfNotMin();
        item.decreaseQualityIfNotMin();
    }
}
