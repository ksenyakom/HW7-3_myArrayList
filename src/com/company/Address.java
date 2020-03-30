package com.company;

import java.util.Objects;

public class Address  {
    String city;
    String street;
    int houseNumber;
    int flatNumber;

    public Address() {
    }

    public Address(String city, String street, int houseNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }
    public Address(String city, String street, int houseNumber, int flatNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }



    public String getFullAddress() {
        String fullAddress = "г." + this.city + ", ул." + this.street + " " + this.houseNumber;
        if (this.flatNumber>0 ) {fullAddress = fullAddress +"-" + this.flatNumber;}
        return fullAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber &&
                flatNumber == address.flatNumber &&
                city.equals(address.city) &&
                street.equals(address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, houseNumber, flatNumber);
    }


}
