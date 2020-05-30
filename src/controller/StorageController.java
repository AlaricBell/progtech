package controller;

import factory.CoffeeFactory;
import model.Coffee;
import model.Storage;
import view.Prompt;

import java.text.DecimalFormat;

public class StorageController {
    private static Storage storage;
    private Prompt prompter;

    public StorageController() {
        storage = Storage.getStorageInstance();
        prompter = new Prompt();
    }

    public void handleUserInput() throws Exception {
        boolean quit = false;
        do {
            String order = prompter.getUserInput(prompter.promptOptions);
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
                    storage.fillStorageByType(CoffeeFactory.makeCoffee(coffeeType, flavour));
                    break;
                case "3":
                    prompter.promptOutput(storage.getQuantityAllByType());
                    break;
                case "q":
                    quit = true;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid input was given!");
            }
        } while(!quit);
    }

    public void addCoffeeToStorage(String chosenCoffeeType, String chosenFlavour) throws Exception {
        //String chosenCoffeeType = prompter.getUserInput(prompter.promptOrderOptions1);
        storage.add(makeCoffee(chosenCoffeeType, chosenFlavour));
    }

    public void removeCoffeeFromStorage(Coffee orderedCoffee) throws Exception {
        storage.removeCoffeeByType(orderedCoffee);
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
        String isFlavoured = prompter.getUserInput(prompter.promptOrderOptions2);
        if(isFlavoured.toLowerCase().equals("y")) {
            switch (prompter.getUserInput(prompter.promptOrderOptions3)) {
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
        String coffeeType = prompter.getUserInput(prompter.promptOrderOptions1);
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
        prompter.promptOutput(response);
    }
}
