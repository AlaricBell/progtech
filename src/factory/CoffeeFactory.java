package factory;

import model.Coffee;
import model.addons.*;
import model.coffees.*;

import java.security.InvalidAlgorithmParameterException;

public class CoffeeFactory {
    public static Coffee makeCoffee(String coffeeType, String flavour) throws IllegalArgumentException {
        if(coffeeType.toLowerCase().equals("espresso")) {
            if (flavour != null) {
                return addFlavour(new Espresso(), flavour);
            }
            return new Espresso();
        }
        else if(coffeeType.toLowerCase().equals("latte")) {
            if (flavour != null) {
                return addFlavour(new Latte(), flavour);
            }
            return new Latte();
        }
        else if(coffeeType.toLowerCase().equals("macchiato")) {
            if (flavour != null) {
                return addFlavour(new Macchiato(), flavour);
            }
            return new Macchiato();
        }
        else if(coffeeType.toLowerCase().equals("cappuccino")) {
            if (flavour != null) {
                return addFlavour(new Cappuccino(), flavour);
            }
            return new Cappuccino();
        }
        else {
            throw new IllegalArgumentException("Invalid parameter value in CoffeeFactory.makeCoffee()");
        }
    }

    public static Coffee addFlavour(Coffee coffee, String flavour) throws IllegalArgumentException {
        if(flavour.toLowerCase().equals("vanillaflavour")) {
            return new VanillaFlavour(coffee);
        }
        else if(flavour.toLowerCase().equals("caramelflavour")) {
            return new CaramelFlavour(coffee);
        }
        else if(flavour.toLowerCase().equals("chocolateflavour")) {
            return new ChocolateFlavour(coffee);
        }
        else {
            throw new IllegalArgumentException("Invalid parameter value in CoffeeFactory.addFlavour()");
        }
    }
}
