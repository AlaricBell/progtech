package model.coffees;

import model.Coffee;

public class Latte extends Coffee {
    public Latte() {
        this.cost = 3.20;
        this.description = "Not too coffee but still coffee..";
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
