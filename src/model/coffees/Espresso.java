package model.coffees;

import model.Coffee;

public class Espresso extends Coffee {
    public Espresso() {
        this.cost = 2.50;
        this.description = "Classic coffee experience with the well-known high quality...";
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
