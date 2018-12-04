package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void qualityCannotExceedMax() {
        // ARRANGE
        Item monItem = new Item("toto", 12, 50);

        // ACT
        monItem.increaseQualityIfNotMax();

        // ASSERT
        assertEquals(50, monItem.quality);
    }

    @Test
    public void qualityCanIncreaseIfNotMax() {
        // ARRANGE
        Item monItem = new Item("toto", 12, 48);

        // ACT
        monItem.increaseQualityIfNotMax();

        // ASSERT
        assertEquals(49, monItem.quality);
    }

}