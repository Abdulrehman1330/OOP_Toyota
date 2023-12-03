package com.example.finalproject;


public enum Models {
    COROLLA(5,"Corolla", "2NR-FE", 1800, "Michelin", "BI-PROJECTOR Led", "PETROL", 2500, 1500),YARIS(5,"Yaris", "XP-150", 1300, "CONTINENTAL", "XENON", "PETROL", 2000, 1000),SUPRA(2,"Supra", "B48", 3700, "MICHELIN SUPREMACY 3ST", "PROEJECTOR", "PETROL", 8000, 6500),FORTUNER(7,"Fortuner", "2TR-FE", 2800, "YOKOHAMA", "Halogen headlamps", "PETROL", 6000, 5000),LANDCRUISER(7,"Land Cruiser", "1VD-FTV", 3000, "PIRELLI", "HID headlamps", "PETROL", 12000, 10500),PRIUS(5,"Prius", "2ZR-FXE", 1500, "BRIDGESTONE","LED Bulbs", "PETROL & HYBRID", 6500, 4000);

    private final int seats;
    private final String name;
    private final String engine;
    private final int engineSize;
    private final String tyre;
    private final String headlights;
    private final String engineType;
    private final int buyprice;
    private final int sellprice;

    Models(int seat, String name, String engine, int engineSize, String tyre, String headlights, String enginetype, int buyprice, int sellprice){
        this.seats = seat;
        this.name = name;
        this.engine = engine;
        this.engineSize = engineSize;
        this.tyre= tyre;
        this.headlights = headlights;
        this.engineType = enginetype;
        this.buyprice= buyprice;
        this.sellprice = sellprice;
    }

    public int getSeats() {
        return seats;
    }

    public String getName() {
        return name;
    }

    public String getEngine() {
        return engine;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public String getTyre() {
        return tyre;
    }

    public String getHeadlights() {
        return headlights;
    }

    public String getEngineType() {
        return engineType;
    }
    public int getBuyprice() {
        return buyprice;
    }

    public int getSellprice() {
        return sellprice;
    }

    @Override
    public String toString() {
        return "Toyota " + name + '\n' + "FEATURES ARE AS BELOW" + '\n' +
                " Seats " + seats + '\n' +
                " Engine name " + engine + '\n' +
                " Engine Size " + engineSize + '\n' +
                " Tyres " + tyre + '\n' +
                " Headlights " + headlights + '\n' +
                " Engine Type " + engineType + '\n' +
                " Buy price " + buyprice + '\n' +
                " Sell price " + sellprice;
    }
}

