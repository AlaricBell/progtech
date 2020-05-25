package model;

import model.coffees.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static Storage firstInstance = null;
    private static final int MAX_QUANTITY = 200;
    private List<Coffee> coffeeStorage;

    private Storage() {
        coffeeStorage = new ArrayList<Coffee>();
    }
    public static Storage getStorageInstance() {
        if (firstInstance == null) {
            firstInstance = new Storage();
        }
        return firstInstance;
    }

    public void add(Coffee coffee) {
        coffeeStorage.add(coffee);
    }

    public String getQuantityAllByType() {
        String temp = "Espresso: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> coffee instanceof Espresso).count()) + "\n";
        temp += "Latte: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> coffee instanceof Latte).count()) + "\n";
        temp += "Cappuccino: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> coffee instanceof Cappuccino).count()) + "\n";
        temp += "Macchiato: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> coffee instanceof Macchiato).count()) + "\n";
        return temp;
    }
}
