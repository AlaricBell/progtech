package model;

import model.Coffee;

public abstract class AddonDecorator extends Coffee {
    protected Coffee coffee;

    public AddonDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public void setCost(double cost) {
        coffee.setCost(cost);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public void setDescription(String description) {
        coffee.setDescription(description);
    }
}
