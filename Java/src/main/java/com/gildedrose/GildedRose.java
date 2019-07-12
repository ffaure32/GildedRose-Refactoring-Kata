package com.gildedrose;

import com.gildedrose.updater.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
            updateSellIn(item);
        }
    }

    private void updateSellIn(Item item) {
        if(!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.decreaseSellIn();
        }
    }

    private void updateItemQuality(Item item) {
        ItemUpdater updater =
            switch (item.name) {
                case "Aged Brie"-> new AgingWellItemUpdater();
                case "Backstage passes to a TAFKAL80ETC concert" -> new DueDateItemUpdater();
                case "Sulfuras, Hand of Ragnaros" ->  new LegendaryItemUpdater();
                default -> new DefaultItemUpdater();
            };
        updater.updateQuality(item);
    }

}