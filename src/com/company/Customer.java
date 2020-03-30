package com.company;

import java.util.Objects;

public class Customer {
   public String name;
    public String surname;
    public int age;
    public Address address;

    public Customer() {
    }

    public Customer(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Customer(String name, String surname, int age, Address address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public String getFullName() {
        String name = this.name + " " + this.surname;
        return name;
    }

    @Override
    public String toString() {
        String s =  getFullName()+", " + getAge();
        if (address!=null) s=s +", "+ getFullAddress() + ".";

        return s;
    }

    public String getFullAddress() {
        return address.getFullAddress();

    }
    public String getAge(){
        int dev = this.age%10;
        String s = String.valueOf(this.age);
        if (dev==0 || dev>=5) s = s+ " лет";
        else if (dev == 1) s = s + " год";
        else s = s + " года";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age &&
                Objects.equals(name, customer.name) &&
                Objects.equals(surname, customer.surname) &&
                Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }


}
