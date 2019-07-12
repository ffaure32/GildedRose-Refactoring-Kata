package com.gildedrose.updater;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemUpdaterTest {
    @ParameterizedTest
    @CsvSource({"4,6,7", "0,6,8"})
    public void oldingWellItemQualityIncreases(int sellin, int originQuality, int expectedQualityAfterUpdate) {
        // ARRANGE
        var oldingWellItem = new Item("old brie", sellin, originQuality);
        ItemUpdater updater = new AgingWellItemUpdater();

        // ACT
        updater.updateQuality(oldingWellItem);

        // ASSERT
        assertEquals(expectedQualityAfterUpdate, oldingWellItem.quality);
    }


    @ParameterizedTest
    @CsvSource({"12,6,7", "9,6,8", "4,6,9", "0,6,0"})
    public void dueDateItemQualityIncreasesTillExpiration(int sellin, int originQuality, int expectedQualityAfterUpdate) {
        // ARRANGE
        var expiringItem = new Item("expiring", sellin, originQuality);
        ItemUpdater updater = new DueDateItemUpdater();

        // ACT
        updater.updateQuality(expiringItem);

        // ASSERT
        assertEquals(expectedQualityAfterUpdate, expiringItem.quality);
    }

    @ParameterizedTest
    @CsvSource({"12,6,6", "9,6,6", "4,6,6", "0,6,6"})
    public void legendaryItemDoesNotChange(int sellin, int originQuality, int expectedQualityAfterUpdate) {
        // ARRANGE
        var legendary = new Item("legendary", sellin, originQuality);
        ItemUpdater updater = new LegendaryItemUpdater();

        // ACT
        updater.updateQuality(legendary);

        // ASSERT
        assertEquals(expectedQualityAfterUpdate, legendary.quality);
    }

    @ParameterizedTest
    @CsvSource({"12,6,5", "0,6,4"})
    public void defaultItemsLoseQuality(int sellin, int originQuality, int expectedQualityAfterUpdate) {
        // ARRANGE
        var legendary = new Item("default", sellin, originQuality);
        ItemUpdater updater = new DefaultItemUpdater();

        // ACT
        updater.updateQuality(legendary);

        // ASSERT
        assertEquals(expectedQualityAfterUpdate, legendary.quality);
    }

    @ParameterizedTest
    @CsvSource({"12,6,4", "0,6,2"})
    public void ProgeriaItemsLoseQualityFaster(int sellin, int originQuality, int expectedQualityAfterUpdate) {
        // ARRANGE
        var progeriaItem = new Item("progeria", sellin, originQuality);
        ItemUpdater updater = new AgingBadItemUpdater();

        // ACT
        updater.updateQuality(progeriaItem);

        // ASSERT
        assertEquals(expectedQualityAfterUpdate, progeriaItem.quality);
    }

    @Test
    public void sellInDecreaseByDefault() {
        // ARRANGE
        var item = new Item("default", 5, 3);
        ItemUpdater updater = new DefaultItemUpdater();

        // ACT
        updater.updateSellIn(item);

        // ASSERT
        assertEquals(4, item.sellIn);
    }

    @Test
    public void sellInDoesntChangeForLegendaryItem() {
        // ARRANGE
        var item = new Item("legendary", 5, 3);
        ItemUpdater updater = new LegendaryItemUpdater();

        // ACT
        updater.updateSellIn(item);

        // ASSERT
        assertEquals(5, item.sellIn);
    }
}
