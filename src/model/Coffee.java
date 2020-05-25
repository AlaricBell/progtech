package model;

public abstract class Coffee {
    protected double cost;
    protected String description;

    public abstract double getCost();
    public abstract void setCost(double price);

    public abstract String getDescription();
    public abstract void setDescription(String desc);
}
