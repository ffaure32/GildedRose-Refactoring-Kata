package com.gildedrose;

import java.util.Arrays;

public enum ItemType {
    UNKOWN_ITEM("Unknown"),
    AGED_BRIE("Aged Brie", new LinearIncreaseQualityUpdater()),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert", new DueDateItemQualityUpdater(), new OutOfDateQualityUpdater()),
    SULFURAS_HAND_OF_RAGNAROS("Sulfuras, Hand of Ragnaros", new LegendaryItemQualityUpdater());

    public final String itemName;
    public final QualityUpdater qualityUpdater;
    public final QualityUpdater qualityUpdaterAfterSellIn;

    ItemType(String name) {
        this(name, new DefaultQualityUpdater(), new DefaultQualityUpdater());
    }

    ItemType(String name, QualityUpdater qualityUpdater) {
        this(name, qualityUpdater, qualityUpdater);
    }

    ItemType(String name, QualityUpdater qualityUpdater, QualityUpdater qualityUpdaterAfterSellIn) {
        this.itemName = name;
        this.qualityUpdater = qualityUpdater;
        this.qualityUpdaterAfterSellIn = qualityUpdaterAfterSellIn;
    }


    public static ItemType getByName(final String expectedname) {
        return Arrays.stream(ItemType.values()).filter(it -> it.itemName.equals(expectedname)).findAny().orElse(UNKOWN_ITEM);
    }


}
