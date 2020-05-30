package model;

import model.Coffee;

public abstract class AddonDecorator extends Coffee {
    protected Coffee coffeeType;

    public AddonDecorator(Coffee coffee) {
        this.coffeeType = coffee;
    }

    @Override
    public double getCost() {
        return coffeeType.getCost();
    }

    @Override
    public void setCost(double cost) {
        coffeeType.setCost(cost);
    }

    @Override
    public String getDescription() {
        return coffeeType.getDescription();
    }

    @Override
    public void setDescription(String description) {
        coffeeType.setDescription(description);
    }
}
