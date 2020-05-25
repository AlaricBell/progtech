package model.addons;

import model.AddonDecorator;
import model.Coffee;

public class ChocolateFlavour extends AddonDecorator {
    public ChocolateFlavour(Coffee coffee) {
        super(coffee);
        this.cost = super.getCost() + 0.60;
        this.description = super.getDescription() + " with chocolate";
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
