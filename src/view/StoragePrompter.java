package view;

public class StoragePrompter extends Prompt {
    private String storageOptions = "*************** Coffee Storage App ***************\n"
            + "1. Order\n2. Fill Storage\n3. Show Storage\n4. Manage price\nq. Quit";
    private String coffeeOptions = "Enter the number of the coffee.\n"
            + "1. Espresso\n2. Latte\n3. Macchiato\n4. Cappuccino\n";
    private String needFlavourOptions = "Do you want additional flavours? (y/n)";
    private String flavourOptions = "Enter the number of the flavour.\n"
            + "1. Vanilla\n2. Caramel\n3. Chocolate\n";

    public String getStorageOptions() {
        return this.storageOptions;
    }
    public String getCoffeeOptions() {
        return this.coffeeOptions;
    }
    public String getNeedFlavourOptions() {
        return this.needFlavourOptions;
    }
    public String getFlavourOptions() {
        return this.flavourOptions;
    }
}
