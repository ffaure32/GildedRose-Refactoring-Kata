package com.gildedrose;

import com.gildedrose.updater.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = getItemUpdater(item);
            updater.updateQuality(item);
            updater.updateSellIn(item);
        }
    }

    private ItemUpdater getItemUpdater(Item item) {
        return switch (item.name) {
            case "Aged Brie" -> new AgingWellItemUpdater();
            case "Backstage passes to a TAFKAL80ETC concert" -> new DueDateItemUpdater();
            case "Sulfuras, Hand of Ragnaros" -> new LegendaryItemUpdater();
            default -> new DefaultItemUpdater();
        };
    }

}