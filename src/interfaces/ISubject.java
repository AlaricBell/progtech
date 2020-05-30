package interfaces;

import model.Coffee;

public interface ISubject {
    public void fillStorageByType(String coffeeType, String flavour);
    public void removeCoffeeFromStorage(Coffee coffee) throws Exception;
    public void notifyObserver(Coffee coffee, double price) throws Exception;
}
