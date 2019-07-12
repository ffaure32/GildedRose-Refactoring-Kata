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
}
