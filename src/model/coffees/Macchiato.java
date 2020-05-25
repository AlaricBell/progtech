package model.coffees;

import model.Coffee;

public class Macchiato extends Coffee {
    public Macchiato() {
        this.cost = 3.40;
        this.description = "Gentle, soft aroma..";
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
