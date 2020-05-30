import controller.StorageController;
import factory.CoffeeFactory;
import model.Coffee;
import model.Storage;
import model.addons.*;
import model.coffees.*;
import view.Prompt;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StorageController storageController = new StorageController();
        Prompt prompter = new Prompt();

        storageController.seedStorage();

        do {
            try {
                storageController.handleUserInput();
            } catch (Exception e) {
                prompter.promptOutput(e.getMessage());
            }
        } while(true);
    }
}
