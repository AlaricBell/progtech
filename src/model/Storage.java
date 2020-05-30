package model;

import model.addons.CaramelFlavour;
import model.addons.ChocolateFlavour;
import model.addons.VanillaFlavour;
import model.coffees.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    // Implemented a delete instance for unit test purposes since this class is a singleton
    public static void deleteStorageInstance() {
        firstInstance = null;
    }

    public void add(Coffee coffee) throws Exception {
        if (validateQuantity(coffee)) {
            coffeeStorage.add(coffee);
        } else {
            throw new Exception("Storage is full");
        }
    }

    public void removeCoffeeByType(Coffee coffee) throws Exception {
        if (coffeeStorage.contains(coffee)){
            coffeeStorage.remove(coffee);
        } else  {
            throw new Exception("We ran out of this type of coffee.");
        }
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
        temp += "Vanilla Espresso: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> (coffee instanceof VanillaFlavour &&
                ((VanillaFlavour) coffee).coffeeType instanceof Espresso)).count()) + "\n";
        temp += "Vanilla Latte: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> (coffee instanceof VanillaFlavour &&
                ((VanillaFlavour) coffee).coffeeType instanceof Latte)).count()) + "\n";
        temp += "Vanilla Macchiato: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> (coffee instanceof VanillaFlavour &&
                ((VanillaFlavour) coffee).coffeeType instanceof Macchiato)).count()) + "\n";
        temp += "Vanilla Cappuccino: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> (coffee instanceof VanillaFlavour &&
                ((VanillaFlavour) coffee).coffeeType instanceof Cappuccino)).count()) + "\n";
        temp += "Caramel Espresso: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> (coffee instanceof CaramelFlavour &&
                ((CaramelFlavour) coffee).coffeeType instanceof Espresso)).count()) + "\n";
        temp += "Caramel Latte: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> (coffee instanceof CaramelFlavour &&
                ((CaramelFlavour) coffee).coffeeType instanceof Latte)).count()) + "\n";
        temp += "Caramel Macchiato: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> (coffee instanceof CaramelFlavour &&
                ((CaramelFlavour) coffee).coffeeType instanceof Macchiato)).count()) + "\n";
        temp += "Caramel Cappuccino: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> (coffee instanceof CaramelFlavour &&
                ((CaramelFlavour) coffee).coffeeType instanceof Cappuccino)).count()) + "\n";
        temp += "Chocolate Espresso: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> (coffee instanceof ChocolateFlavour &&
                ((ChocolateFlavour) coffee).coffeeType instanceof Espresso)).count()) + "\n";
        temp += "Chocolate Latte: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> (coffee instanceof ChocolateFlavour &&
                ((ChocolateFlavour) coffee).coffeeType instanceof Latte)).count()) + "\n";
        temp += "Chocolate Macchiato: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> (coffee instanceof ChocolateFlavour &&
                ((ChocolateFlavour) coffee).coffeeType instanceof Macchiato)).count()) + "\n";
        temp += "Chocolate Cappuccino: ";
        temp += Long.toString(coffeeStorage.stream().filter(coffee -> (coffee instanceof ChocolateFlavour &&
                ((ChocolateFlavour) coffee).coffeeType instanceof Cappuccino)).count()) + "\n";
        return temp;
    }
    //I tried...
    public boolean validateQuantity(Coffee coffee) throws IllegalArgumentException {
        if(!coffeeStorage.isEmpty()) {
            if (coffee instanceof Espresso) {
                if(coffeeStorage.stream().filter(c -> c instanceof Espresso).count() >= MAX_QUANTITY)  return false;
            }
            else if(coffee instanceof Latte) {
                if(coffeeStorage.stream().filter(c -> c instanceof Latte).count() >= MAX_QUANTITY)  return false;
            }
            else if(coffee instanceof Macchiato) {
                if(coffeeStorage.stream().filter(c -> c instanceof Macchiato).count() >= MAX_QUANTITY)  return false;
            }
            else if(coffee instanceof Cappuccino) {
                if(coffeeStorage.stream().filter(c -> c instanceof Cappuccino).count() >= MAX_QUANTITY)  return false;
            }
            else if(coffee instanceof VanillaFlavour) {
                if(coffeeStorage.stream().filter(c -> c instanceof VanillaFlavour).count() >= MAX_QUANTITY)  return false;
            }
            else if(coffee instanceof CaramelFlavour) {
                if(coffeeStorage.stream().filter(c -> c instanceof CaramelFlavour).count() >= MAX_QUANTITY)  return false;
            }
            else if(coffee instanceof ChocolateFlavour) {
                if(coffeeStorage.stream().filter(c -> c instanceof ChocolateFlavour).count() >= MAX_QUANTITY)  return false;
            }
            else {
                throw new IllegalArgumentException("Invalid parameter value in Storage.validateQuantity");
            }
        }
        return true;
    }

    public Coffee getCoffeeByType(String coffeeType) throws Exception {
        Coffee orderedCoffee;
        try {
            orderedCoffee = coffeeStorage.stream().filter(coffee -> coffee.getClass().getSimpleName().toLowerCase().equals(coffeeType.toLowerCase())).findFirst().get();
        } catch(Exception e) {
            throw new Exception("No coffee of this type present!");
        }
        return orderedCoffee;
    }

    public ArrayList<Coffee> getFilteredCoffeesByType(Coffee coffee) throws Exception{
        if(!coffeeStorage.isEmpty()) {
            if (coffee instanceof Espresso) {
                return new ArrayList<Coffee>(coffeeStorage.stream().filter(c -> c instanceof Espresso).collect(Collectors.toList()));
            } else if (coffee instanceof Latte) {
                return new ArrayList<Coffee>(coffeeStorage.stream().filter(c -> c instanceof Latte).collect(Collectors.toList()));
            } else if (coffee instanceof Macchiato) {
                return new ArrayList<Coffee>(coffeeStorage.stream().filter(c -> c instanceof Macchiato).collect(Collectors.toList()));
            } else if (coffee instanceof Cappuccino) {
                return new ArrayList<Coffee>(coffeeStorage.stream().filter(c -> c instanceof Cappuccino).collect(Collectors.toList()));
            } else if (coffee instanceof VanillaFlavour) {
                return new ArrayList<Coffee>(coffeeStorage.stream().filter(c -> c instanceof VanillaFlavour).collect(Collectors.toList()));
            } else if (coffee instanceof CaramelFlavour) {
                return new ArrayList<Coffee>(coffeeStorage.stream().filter(c -> c instanceof CaramelFlavour).collect(Collectors.toList()));
            } else if (coffee instanceof ChocolateFlavour) {
                return new ArrayList<Coffee>(coffeeStorage.stream().filter(c -> c instanceof ChocolateFlavour).collect(Collectors.toList()));
            } else {
                throw new Exception("Invalid parameter value in Storage.GetFilteredCoffeesByType");
            }
        } else {
            throw new Exception("Storage is empty");
        }
    }

    public void fillStorageByType(Coffee coffee) {
        while (validateQuantity(coffee)) {
            if (coffee instanceof Espresso) coffeeStorage.add(new Espresso());
            if (coffee instanceof Latte) coffeeStorage.add(new Latte());
            if (coffee instanceof Macchiato) coffeeStorage.add(new Macchiato());
            if (coffee instanceof Cappuccino) coffeeStorage.add(new Cappuccino());
            if (coffee instanceof VanillaFlavour) coffeeStorage.add(new VanillaFlavour(((VanillaFlavour) coffee).coffeeType));
            if (coffee instanceof CaramelFlavour) coffeeStorage.add(new CaramelFlavour(((CaramelFlavour) coffee).coffeeType));
            if (coffee instanceof ChocolateFlavour) coffeeStorage.add(new ChocolateFlavour(((ChocolateFlavour) coffee).coffeeType));
        }
    }
}
