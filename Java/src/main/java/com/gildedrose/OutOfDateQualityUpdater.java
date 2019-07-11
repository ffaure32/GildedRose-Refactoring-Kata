package com.gildedrose;

public class OutOfDateQualityUpdater implements QualityUpdater {
    @Override
    public void updateQuality(Item item) {
        item.quality = 0;
    }
}
