package model;

import model.coffees.Latte;

import java.util.ArrayList;
import java.util.List;

public class Storage <T extends Coffee> {
    private static Storage firstInstance = null;
    private List<T> coffeeStorage;

    private Storage() {
        coffeeStorage = new ArrayList<T>();
    }
    public static Storage getStorageInstance() {
        if (firstInstance == null) {
            firstInstance = new Storage();
        }
        return firstInstance;
    }
}
