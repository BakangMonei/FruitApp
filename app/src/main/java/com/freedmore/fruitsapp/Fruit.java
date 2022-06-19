package com.freedmore.fruitsapp;

public class Fruit {
    private String fruitName;
    private int fruitImage;
    private String fruitDescription;
    private double fruitPrice;

    public Fruit(String fruitName, int fruitImage, String fruitDescription,Double fprice ) {
        this.fruitName = fruitName;
        this.fruitImage = fruitImage;
        this.fruitDescription = fruitDescription;
        this.fruitPrice = fprice;
    }

    public double getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(double fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getFruitImage() {
        return fruitImage;
    }

    public void setFruitImage(int fruitImage) {
        this.fruitImage = fruitImage;
    }

    public String getFruitDescription() {
        return fruitDescription;
    }

    public void setFruitDescription(String fruitDescription) {
        this.fruitDescription = fruitDescription;
    }
}
