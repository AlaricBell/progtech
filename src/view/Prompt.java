package view;

import java.util.Scanner;

public abstract class Prompt {
    public static Scanner scanner = new Scanner(System.in);

    public static void promptOutput(String output) {
        System.out.println(output);
    }

    public static String getUserInput(String task) {
        System.out.println(task);
        return scanner.nextLine();
    }
}
