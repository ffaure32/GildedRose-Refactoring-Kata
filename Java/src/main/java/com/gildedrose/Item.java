package com.gildedrose;

public class Item {

    public static final int MAX_QUALITY = 50;
    public String name;

    public int sellIn;

    public int quality;

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

    void increaseQualityIfNotMax() {
        if (quality < MAX_QUALITY) {
            quality = quality + 1;
        }
    }

    void decreaseSellin() {
        sellIn = sellIn - 1;
    }
}
