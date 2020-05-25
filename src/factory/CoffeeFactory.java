package factory;

import model.Coffee;
import model.addons.*;
import model.coffees.*;

import java.security.InvalidAlgorithmParameterException;

public class CoffeeFactory {
    public Coffee makeCoffee(String newCoffee, String flavour) throws InvalidAlgorithmParameterException {
        if(newCoffee.toLowerCase().equals("espresso")) {
            if (flavour != null) {
                return addFlavour(new Espresso(), flavour);
            }
            return new Espresso();
        }
        else if(newCoffee.toLowerCase().equals("latte")) {
            if (flavour != null) {
                return addFlavour(new Latte(), flavour);
            }
            return new Latte();
        }
        else if(newCoffee.toLowerCase().equals("macchiato")) {
            if (flavour != null) {
                return addFlavour(new Macchiato(), flavour);
            }
            return new Macchiato();
        }
        else if(newCoffee.toLowerCase().equals("cappuccino")) {
            if (flavour != null) {
                return addFlavour(new Cappuccino(), flavour);
            }
            return new Cappuccino();
        }
        else {
            throw new InvalidAlgorithmParameterException("Invalid parameter value in factory.make");
        }
    }

    public Coffee addFlavour(Coffee coffee, String flavour) throws InvalidAlgorithmParameterException {
        if(flavour.toLowerCase().equals("vanilla")) {
            return new VanillaFlavour(coffee);
        }
        else if(flavour.toLowerCase().equals("caramel")) {
            return new CaramelFlavour(coffee);
        }
        else if(flavour.toLowerCase().equals("caramel")) {
            return new ChocolateFlavour(coffee);
        }
        else {
            throw new InvalidAlgorithmParameterException("Invalid parameter value in factory.make");
        }
    }
}
