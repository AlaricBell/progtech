import model.Coffee;
import model.Storage;
import model.addons.*;
import model.coffees.*;

public class Main {
    public static void main(String[] args) {
        Storage s = Storage.getStorageInstance();

        s.add(new Latte());
        s.add(new Latte());
        s.add(new Espresso());
        System.out.println(s.getQuantityAllByType());
    }
}
