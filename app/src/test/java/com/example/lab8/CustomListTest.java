package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList mockCustomList() {
        CustomList CustomList = new CustomList();
        CustomList.add(mockCity());
        return CustomList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAdd() {
        CustomList CustomList = mockCustomList();
        assertEquals(1, CustomList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        CustomList.add(city);
        assertEquals(2, CustomList.getCities().size());
        assertTrue(CustomList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CustomList CustomList = mockCustomList();
        City city = new City("Yellowknife", "Northwest Territories");
        CustomList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            CustomList.add(city);
        });
    }
    @Test
    void testGetCities() {
        CustomList CustomList = mockCustomList();
        assertEquals(0, mockCity().compareTo(CustomList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        CustomList.add(city);
        assertEquals(0, city.compareTo(CustomList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(CustomList.getCities().get(1)));
    }

    @Test
    void testHasCities(){
        CustomList CustomList = mockCustomList();
        City city = new City("Calgary", "Alberta");
        CustomList.add(city);
        assertTrue(CustomList.hasCity(mockCity()));
        assertTrue(CustomList.hasCity(city));

    }

    @Test
    void testDelete(){
        CustomList CustomList = mockCustomList();
        City city = new City("Calgary", "Alberta");
        CustomList.add(city);
        CustomList.delete(mockCity());
        assertFalse(CustomList.hasCity(mockCity()));
    }

    @Test
    void testCountCities(){
        CustomList CustomList = mockCustomList();
        assertEquals(1,CustomList.countCities());
        City city = new City("Calgary", "Alberta");
        CustomList.add(city);
        assertEquals(2,CustomList.countCities());
    }

}
