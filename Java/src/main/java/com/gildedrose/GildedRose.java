package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (Item item : items) {
            updateItemQuality(item);
            updateSellIn(item);
        }
    }

    private void updateSellIn(Item item) {
        if (item.getName().equals("Sulfuras, Hand of Ragnaros")) {
            // LEGENDARY ITEM DOES NOT CHANGE
        } else {
            item.decreaseSellIn();
        }
    }

    private void updateItemQuality(Item item) {
        ItemUpdater updater = getItemUpdater(item);
        updater.updateQuality(item);
    }

    private ItemUpdater getItemUpdater(Item item) {
        return switch (item.getName()) {
            case "Aged Brie" -> new CheeseQualityUpdater();
            case "Mimolette Vieille" -> new CheeseQualityUpdater();
            case "Backstage passes to a TAFKAL80ETC concert" -> new ExpiringItemQualityUpdater();
            case "Sulfuras, Hand of Ragnaros" -> new LegendaryQualityUpdater();
            default -> new DefaultQualityUpdater();
        };
    }

}