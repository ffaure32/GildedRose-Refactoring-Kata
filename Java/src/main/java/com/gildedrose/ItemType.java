package com.gildedrose;

import java.util.Arrays;
import java.util.Optional;

public enum ItemType {
    AGED_BRIE("Aged Brie", new AgedBrieUpdater()),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert", new BackStageUpdater()),
    SULFURAS_HAND_OF_RAGNAROS("Sulfuras, Hand of Ragnaros", new LegendaryUpdater()),
    DEFAULT("Any", new DefaultUpdater());

    private String name;
    public final ItemUpdater updater;

    ItemType(String name, ItemUpdater updater) {
        this.name = name;
        this.updater = updater;
    }

    public static ItemType getByName(String name) {
        Optional<ItemType> first = Arrays.stream(ItemType.values())
                .filter(type -> name.equals(type.name))
                .findFirst();
        return first.orElse(DEFAULT);
    }
}
