package com.example.lab5_starter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a city with a name and province.
 * <p>
 * Two {@code City} objects are considered equal when they share
 * the same {@code name} and {@code province} (case-sensitive).
 * </p>
 */
public class City implements Serializable {

    /** The name of the city. */
    private String name;

    /** The province the city belongs to. */
    private String province;

    /**
     * Constructs a new {@code City} with the given name and province.
     *
     * @param name     the name of the city
     * @param province the province the city belongs to
     */
    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }

    /**
     * Returns the province of this city.
     *
     * @return the province string
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the province of this city.
     *
     * @param province the new province value
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Returns the name of this city.
     *
     * @return the city name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this city.
     *
     * @param name the new city name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks whether this city is logically equal to another object.
     * <p>
     * Two cities are equal if and only if both their {@code name}
     * and {@code province} fields are equal.
     * </p>
     *
     * @param o the object to compare with
     * @return {@code true} if {@code o} is a {@code City} with the same
     *         name and province; {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) && Objects.equals(province, city.province);
    }

    /**
     * Returns a hash code for this city derived from its name and province.
     *
     * @return the computed hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, province);
    }

    /**
     * Returns a human-readable representation of this city.
     *
     * @return a string in the format {@code "City{name='...', province='...'}"}
     */
    @Override
    public String toString() {
        return "City{name='" + name + "', province='" + province + "'}";
    }
}
