package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemQualityUpdaterTest {
    @Test
    void cheeseItemsGetsBetterWhenAging() {
        // ARRANGE
        ItemUpdater cheeseQualityUpdater = new CheeseQualityUpdater();
        Item cheese = new Item("Aged Brie", 4, 5);

        // ACT
        cheeseQualityUpdater.updateQuality(cheese);

        // ASSERT
        assertEquals(6, cheese.getQuality());
    }

    @Test
    void cheeseItemsGetsEvenBetterWhenExpired() {
        // ARRANGE
        ItemUpdater cheeseQualityUpdater = new CheeseQualityUpdater();
        Item cheese = new Item("Aged Brie", 0, 5);

        // ACT
        cheeseQualityUpdater.updateQuality(cheese);

        // ASSERT
        assertEquals(7, cheese.getQuality());
    }

    @ParameterizedTest
    @CsvSource({"12, 3, 4", "7, 3, 5", "2, 3, 6", "0, 3, 0"})
    void expiringItemsGetBetterAndBetterTillTheyExpire(int sellIn, int originalQuality, int qualityAfterUpdate) {
        // ARRANGE
        ItemUpdater expiringItemUpdater = new ExpiringItemQualityUpdater();
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, originalQuality);


        // ACT
        expiringItemUpdater.updateQuality(backstagePass);

        // ASSERT
        assertEquals(qualityAfterUpdate, backstagePass.getQuality());

    }
}
