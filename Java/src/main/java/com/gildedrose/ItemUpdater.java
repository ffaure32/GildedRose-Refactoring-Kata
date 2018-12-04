package com.gildedrose;

public interface ItemUpdater {
    default void updateItem(Item item) {
        updateQuality(item);
        updateSellin(item);
        if (item.sellIn < 0) {
            updateQualityAfterSellin(item);
        }
    }
    void updateQuality(Item item);
    void updateSellin(Item item);
    void updateQualityAfterSellin(Item item);

    public static ItemUpdater getFromName(String name) {
        return ItemType.getByName(name).updater;
    }

}
