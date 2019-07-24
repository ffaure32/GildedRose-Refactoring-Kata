package com.gildedrose;

public class Item {

    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void decreaseQualityIfNotMin() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    void resetQuality() {
        quality = 0;
    }

    void decreaseSellIn() {
        sellIn = sellIn - 1;
    }

    void increaseQualityIfNotMax() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }
}
