package controller;

import com.sun.tools.javac.Main;
import factory.CoffeeFactory;
import interfaces.ISubject;
import model.Coffee;
import model.Storage;
import view.*;

import java.text.DecimalFormat;

public class StorageController implements ISubject {
    private static Storage storage;
    private StoragePrompter storagePrompter;
    private CostPrompter costPrompter;

    public StorageController() {
        storage = Storage.getStorageInstance();
        storagePrompter = new StoragePrompter();
        costPrompter = new CostPrompter();
    }

    public void seedStorage() {
        fillStorageByType("Espresso", null);
        fillStorageByType("Latte", null);
        fillStorageByType("Macchiato", null);
        fillStorageByType("Cappuccino", null);
    }

    public void handleUserInput() throws Exception {
            String order = Prompt.getUserInput(storagePrompter.getStorageOptions());
            String coffeeType;
            String flavour;
            switch(order) {
                case "1":
                    coffeeType = chooseCoffeeType();
                    flavour = chooseFlavour();
                    orderCoffee(coffeeType, flavour);
                    break;
                case "2":
                    coffeeType = chooseCoffeeType();
                    flavour = chooseFlavour();
                    fillStorageByType(coffeeType, flavour);
                    break;
                case "3":
                    Prompt.promptOutput(storage.getQuantityAllByType());
                    break;
                case "4":
                    coffeeType = chooseCoffeeType();
                    flavour = chooseFlavour();
                    double price = Double.parseDouble(Prompt.getUserInput(costPrompter.getCostChangeOptions()));
                    setPrice(coffeeType, flavour, price);
                case "q":
                    System.exit(0);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid input was given!");
            }
    }

    public void addCoffeeToStorage(String chosenCoffeeType, String chosenFlavour) throws Exception {
        storage.add(makeCoffee(chosenCoffeeType, chosenFlavour));
    }

    public void removeCoffeeFromStorage(Coffee orderedCoffee) throws Exception {
        storage.removeCoffeeByType(orderedCoffee);
    }

    public void fillStorageByType(String coffeeType, String flavour) {
        storage.fillStorageByType(CoffeeFactory.makeCoffee(coffeeType, flavour));
    }

    public void notifyObserver(Coffee coffeeType, double price) throws Exception {
        for (Coffee coffee : storage.getFilteredCoffeesByType(coffeeType)) {
            coffee.update(price);
        }
        throw new Exception("Price of " + coffeeType.getClass().getSimpleName() +  " is set to " + price);
    }

    public Coffee makeCoffee(String chosenCoffeeType, String flavour) throws IllegalArgumentException{
        switch(chosenCoffeeType) {
            case "1":
                return CoffeeFactory.makeCoffee("espresso", flavour);
            case "2":
                return CoffeeFactory.makeCoffee("latte", flavour);
            case "3":
                return CoffeeFactory.makeCoffee("macchiato", flavour);
            case "4":
                return CoffeeFactory.makeCoffee("cappuccino", flavour);
            default:
                throw new IllegalArgumentException("Invalid input was given!");
        }
    }

    public String chooseFlavour() throws IllegalArgumentException {
        String isFlavoured = Prompt.getUserInput(storagePrompter.getNeedFlavourOptions());
        if(isFlavoured.toLowerCase().equals("y")) {
            switch (Prompt.getUserInput(storagePrompter.getFlavourOptions())) {
                case "1":
                    return "vanillaflavour";
                case "2":
                    return "caramelflavour";
                case "3":
                    return "chocolateflavour";
                default:
                    throw new IllegalArgumentException("Invalid input was given!");
            }
        }else if (isFlavoured.toLowerCase().equals("n")) {
            return null;
        }else {
            throw new IllegalArgumentException("Invalid input was given!");
        }
    }

    public String chooseCoffeeType() throws IllegalArgumentException {
        String coffeeType = Prompt.getUserInput(storagePrompter.getCoffeeOptions());
        if(coffeeType.equals("1")) {
            return "Espresso";
        }else if (coffeeType.equals("2")) {
            return "Latte";
        }else if (coffeeType.equals("3")) {
            return "Macchiato";
        }
        else if (coffeeType.equals("4")) {
            return "Cappuccino";
        }
        else {
            throw new IllegalArgumentException("Invalid input was given!");
        }
    }

    public void orderCoffee(String coffeeType, String flavour) throws Exception {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        Coffee coffee = storage.getCoffeeByType((flavour != null) ? flavour : coffeeType);
        String response = "Coffee was ordered for: $" + numberFormat.format(coffee.getCost());
        removeCoffeeFromStorage(coffee);
        Prompt.promptOutput(response);
    }

    public void setPrice(String coffeeType, String flavour, double price) throws Exception {
        Coffee coffee = storage.getCoffeeByType((flavour != null) ? flavour : coffeeType);
        notifyObserver(coffee, price);
    }
}
