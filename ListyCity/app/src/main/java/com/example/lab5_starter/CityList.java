package com.example.lab5_starter;

import java.util.ArrayList;

/**
 * Manages an ordered list of {@link City} objects.
 * <p>
 * All equality comparisons use {@link City#equals(Object)}, which compares
 * cities by their {@code name} and {@code province} fields, not by reference.
 * </p>
 */
public class CityList {

    /** Internal storage for the cities in this list. */
    private final ArrayList<City> cities;

    /**
     * Constructs an empty {@code CityList}.
     */
    public CityList() {
        cities = new ArrayList<>();
    }

    /**
     * Adds a city to the end of the list.
     *
     * @param city the city to add
     * @throws IllegalArgumentException if {@code city} is {@code null}
     */
    public void addCity(City city) {
        if (city == null) {
            throw new IllegalArgumentException("City must not be null.");
        }
        cities.add(city);
    }

    /**
     * Returns whether the given city is present in the list.
     * <p>
     * Comparison is done via {@link City#equals(Object)}, so two distinct
     * {@code City} objects with identical name and province are treated as equal.
     * Returns {@code false} when {@code city} is {@code null}.
     * </p>
     *
     * @param city the city to search for; may be {@code null}
     * @return {@code true} if a logically equal city exists in the list;
     *         {@code false} otherwise
     */
    public boolean hasCity(City city) {
        if (city == null) {
            return false;
        }
        return cities.contains(city);
    }

    /**
     * Removes the first occurrence of the given city from the list.
     * <p>
     * Comparison is done via {@link City#equals(Object)}.
     * </p>
     *
     * @param city the city to remove
     * @throws IllegalArgumentException if {@code city} is {@code null}
     * @throws IllegalArgumentException if {@code city} is not found in the list
     */
    public void delete(City city) {
        if (city == null) {
            throw new IllegalArgumentException("City must not be null.");
        }
        if (!hasCity(city)) {
            throw new IllegalArgumentException("City not found: " + city);
        }
        cities.remove(city);
    }

    /**
     * Returns the number of cities currently in the list.
     *
     * @return the total count of cities
     */
    public int countCities() {
        return cities.size();
    }
}
