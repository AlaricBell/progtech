package model.addons;

import model.AddonDecorator;
import model.Coffee;

public class CaramelFlavour extends AddonDecorator {
    public CaramelFlavour(Coffee coffee) {
        super(coffee);
        this.cost = super.getCost() + 0.80;
        this.description = super.getDescription() + " with caramel";
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public void setCost(double cost) {
        this.cost = super.getCost() + cost;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description =  super.getDescription() + description;
    }
}
