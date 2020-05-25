package model.coffees;

import model.Coffee;

public class Cappuccino extends Coffee {
    public Cappuccino() {
        this.cost = 2.70;
        this.description = "The true flavour of coffee..";
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
