package model;

import interfaces.IStorageObserver;

public abstract class Coffee implements IStorageObserver {
    protected double cost;
    protected String description;

    public abstract double getCost();
    public abstract void setCost(double price);

    public abstract String getDescription();
    public abstract void setDescription(String desc);

    public void update(double price) {
        setCost(price);
    }
}
