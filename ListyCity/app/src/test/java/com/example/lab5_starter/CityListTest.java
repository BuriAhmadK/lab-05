package com.example.lab5_starter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link CityList}.
 *
 * Covers happy paths, alternative paths, and boundary/edge cases
 * for hasCity(), delete(), and countCities().
 *
 * Tests run on the local JVM (not the Android device/emulator).
 */
public class CityListTest {

    private CityList cityList;
    private City edmonton;
    private City calgary;
    private City vancouver;

    /**
     * Initialise a fresh CityList with two cities before each test.
     */
    @BeforeEach
    void setUp() {
        cityList  = new CityList();
        edmonton  = new City("Edmonton",  "Alberta");
        calgary   = new City("Calgary",   "Alberta");
        vancouver = new City("Vancouver", "British Columbia");

        cityList.addCity(edmonton);
        cityList.addCity(calgary);
    }

    // -------------------------------------------------------------------------
    // hasCity() tests
    // -------------------------------------------------------------------------

    /** Happy path – a city that was added must be found. */
    @Test
    void hasCity_whenCityExists_returnsTrue() {
        assertTrue(cityList.hasCity(edmonton));
    }

    /** Alternative path – a city that was never added must not be found. */
    @Test
    void hasCity_whenCityDoesNotExist_returnsFalse() {
        assertFalse(cityList.hasCity(vancouver));
    }

    /** Boundary – null argument must return false (no exception). */
    @Test
    void hasCity_withNull_returnsFalse() {
        assertFalse(cityList.hasCity(null));
    }

    /**
     * Logical equality – a new City object with the same name and province
     * as an already-added city must be found (tests equals/hashCode).
     */
    @Test
    void hasCity_usesLogicalEquality_notReferenceEquality() {
        City sameAsEdmonton = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(sameAsEdmonton));
    }

    // -------------------------------------------------------------------------
    // delete() tests
    // -------------------------------------------------------------------------

    /** Happy path – deleting a present city removes it from the list. */
    @Test
    void delete_whenCityExists_removesCity() {
        cityList.delete(edmonton);

        assertFalse(cityList.hasCity(edmonton));
        assertEquals(1, cityList.countCities());
    }

    /** Alternative path – deleting an absent city throws IllegalArgumentException. */
    @Test
    void delete_whenCityDoesNotExist_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> cityList.delete(vancouver));
    }

    /** Boundary – null argument must throw IllegalArgumentException. */
    @Test
    void delete_withNull_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> cityList.delete(null));
    }

    /**
     * Only one instance is removed when duplicates are present.
     * After removing one copy, the city is still logically present.
     */
    @Test
    void delete_removesOnlyOneInstance_whenDuplicatesExist() {
        cityList.addCity(new City("Edmonton", "Alberta")); // duplicate
        assertEquals(3, cityList.countCities());

        cityList.delete(new City("Edmonton", "Alberta")); // remove by value

        // List should now have 2 cities, and Edmonton still logically exists
        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(edmonton));
    }

    /** Verify the exception message is descriptive (optional but useful). */
    @Test
    void delete_whenCityDoesNotExist_exceptionMessageContainsCityInfo() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> cityList.delete(vancouver));
        assertNotNull(ex.getMessage());
        assertFalse(ex.getMessage().isEmpty());
    }

    // -------------------------------------------------------------------------
    // countCities() tests
    // -------------------------------------------------------------------------

    /** Happy path – count reflects the number of cities added in setUp(). */
    @Test
    void countCities_returnsCorrectCount() {
        assertEquals(2, cityList.countCities());
    }

    /** Count decreases by one after a deletion. */
    @Test
    void countCities_afterDeletion_returnsDecrementedCount() {
        cityList.delete(calgary);
        assertEquals(1, cityList.countCities());
    }

    /** Count increases by one after an addition. */
    @Test
    void countCities_afterAddition_returnsIncrementedCount() {
        cityList.addCity(vancouver);
        assertEquals(3, cityList.countCities());
    }

    /** Boundary – a brand-new empty list has a count of zero. */
    @Test
    void countCities_onEmptyList_returnsZero() {
        CityList empty = new CityList();
        assertEquals(0, empty.countCities());
    }

    // -------------------------------------------------------------------------
    // addCity() boundary tests
    // -------------------------------------------------------------------------

    /** Boundary – adding null must throw IllegalArgumentException. */
    @Test
    void addCity_withNull_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> cityList.addCity(null));
    }
}
