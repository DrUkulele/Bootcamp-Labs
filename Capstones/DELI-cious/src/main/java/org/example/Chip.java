package org.example;

import java.math.BigDecimal;

public class Chip {
    //properties
    private String type;
    private BigDecimal price;

    //constructor
    public Chip(String type) {
        this.type = type;
    }

    //getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getChipPrice(Chip chip){
        return price = BigDecimal.valueOf(1.50);
    }

    @Override
    public String toString() {
        return type + " chips\n";
    }
}
