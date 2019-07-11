package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQuality(item);
            updateSellin(item);
            if (item.sellIn < 0) {
                updateQualityAfterSellIn(item);
            }
        }
    }

    private void updateQualityAfterSellIn(Item item) {
        ItemType.getByName(item.name).qualityUpdaterAfterSellIn.updateQuality(item);
    }

    private void updateSellin(Item item) {
        if (ItemType.getByName(item.name) == ItemType.SULFURAS_HAND_OF_RAGNAROS) {
        } else {
            item.decreaseSellIn();
        }
    }

    private void updateQuality(Item item) {
        ItemType.getByName(item.name).qualityUpdater.updateQuality(item);
    }

}