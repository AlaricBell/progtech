package view;

import java.util.Scanner;

public class Prompt {
    private Scanner scanner = new Scanner(System.in);
    public String promptOptions = "*************** Coffee Storage App ***************\n"
                                + "1. Order\n2. Fill Storage\n";
    public String promptOrderOptions1 = "Enter the number of the drink you'd like to order.\n"
                                 + "1. Espresso\n2. Latte\n3. Macchiato\n4. Cappuccino\n";
    public String promptOrderOptions2 = "Do you want additional flavours? (y/n)";
    public String promptOrderOptions3 = "Enter the number of the flavour you wish to add.\n"
                                 + "1. Vanilla\n2. Caramel\n3. Chocolate\n";

    public void promptOutput(String output) {
        System.out.println(output);
    }

    public String getUserInput(String task) {
        System.out.println(task);
        return scanner.nextLine();
    }
}
