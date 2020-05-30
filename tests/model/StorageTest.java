package model;

import model.coffees.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    Storage storage;
    @BeforeEach
    void setUp() {
        storage = Storage.getStorageInstance();
        storage.fillStorageByType(new Espresso());
    }

    @AfterEach
    void tearDown() {
        Storage.deleteStorageInstance();
    }

    @Test
    void addSingleCoffeeToStorage() throws Exception {
        storage.add(new Latte());
        assertEquals(1, storage.getFilteredCoffeesByType(new Latte()).size());
    }

    @Test
    void validateQuantityOverMaximum() throws Exception{
        assertEquals(false, storage.validateQuantity(new Espresso()));
    }

    @Test
    void validateQuantityUnderMaximum() throws Exception{
        assertEquals(true, storage.validateQuantity(new Latte()));
    }

    @Test
    void getCoffeeFromStorageByType() throws Exception{
        Coffee coffee = storage.getCoffeeByType("Espresso");
        assertEquals(true, coffee instanceof Espresso);
    }

    @Test
    void fillStorageByCoffeeType() throws Exception{
        storage.fillStorageByType(new Cappuccino());
        assertEquals(false, storage.validateQuantity(new Cappuccino()));
    }

    @Test
    void getFilteredCoffeesByTypeFromStorage() throws Exception{
        assertEquals(200, storage.getFilteredCoffeesByType(new Espresso()).size());
    }

    @Test
    void removeCoffeeFromStorage() throws Exception{
        storage.removeCoffeeByType(storage.getCoffeeByType("Espresso"));
        assertEquals(199, storage.getFilteredCoffeesByType(new Espresso()).size());
    }
}