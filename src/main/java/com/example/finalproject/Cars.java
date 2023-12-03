package com.example.finalproject;

import java.io.Serializable;

public class Cars implements Serializable{
    public String name;
    public int seats;
    public String engine;
    public int engineSize;

    public int buyPrice;
    public int sellPrice;


    Cars(Models models) {
        this.name = models.getName();
        this.seats = models.getSeats();
        this.engineSize = models.getEngineSize();
        this.engine = models.getEngine();
        this.buyPrice = models.getBuyprice();
        this.sellPrice = models.getSellprice();

    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return "Toyota "+ name;
    }


    public int getSeats() {
        return seats;
    }


    public String getEngine() {
        return engine;
    }


    public int getEngineSize() {
        return engineSize;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public int getBuyPrice() {
        return buyPrice;
    }
}
