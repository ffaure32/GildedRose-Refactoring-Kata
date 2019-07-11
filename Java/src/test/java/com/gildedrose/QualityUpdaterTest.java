package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QualityUpdaterTest {
    @Test
    public void qualityDecreasesByDefault() {
        Item item = new Item("default", 5 , 4);
        QualityUpdater defaultUpdater = new DefaultQualityUpdater();

        defaultUpdater.updateQuality(item);

         assertEquals(3, item.quality);
    }

    @Test
    public void qualityIsImmutableForLegendaryItem() {
        Item item = new Item("legendary", 5 , 4);
        QualityUpdater legendaryItemUpdater = new LegendaryItemQualityUpdater();

        legendaryItemUpdater.updateQuality(item);

        assertEquals(4, item.quality);
    }

    @ParameterizedTest
    @CsvSource({"12,1", "7,2", "2,3"})
    void qualityIncreaseMoreWhenCloserToSellinForDueDateItem(int sellin, int expectedQuality) {
        Item item = new Item("legendary", sellin, 0);
        QualityUpdater dueDateItemUpdater = new DueDateItemQualityUpdater();

        dueDateItemUpdater.updateQuality(item);

        assertEquals(expectedQuality, item.quality);
    }

    @Test
    void qualityIncreaseForLinearQualityItem() {
        Item item = new Item("linear", 4, 3);
        QualityUpdater linearUpdater = new LinearIncreaseQualityUpdater();

        linearUpdater.updateQuality(item);

        assertEquals(4, item.quality);

    }

    @Test
    void qualityToZeroForOutOfDateQualityItem() {
        Item item = new Item("linear", -1, 3);
        QualityUpdater linearUpdater = new OutOfDateQualityUpdater();

        linearUpdater.updateQuality(item);

        assertEquals(0, item.quality);

    }

}
