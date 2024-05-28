package org.example;

import java.math.BigDecimal;

public class Drink {
    //properties
    private String size;
    private String flavor;
    private BigDecimal price;

    //constructor
    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    //getters and setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public BigDecimal getDrinkPrice(Drink drink){
        switch (drink.size){
            case "Small":
               price = BigDecimal.valueOf(2.00);
               break;
            case "Medium":
                price = BigDecimal.valueOf(2.50);
                break;
            case "Large":
                price = BigDecimal.valueOf(3.00);
                break;
            default:
                break;
        }
        return price;
    }

    @Override
    public String toString() {
        return size + " " + flavor + "\n";
    }
}
