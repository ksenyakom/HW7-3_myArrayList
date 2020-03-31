package com.company;

public class customerClass {
    private int n = 10;
    protected Customer[] base = new Customer[n];
    protected int baseSize = 0;

    public customerClass() {
    }

    public customerClass(Customer[] array) {
        for (int i = 0; i < array.length; i++) {
            this.add(array[i]);
        }
    }

    public int getN() {
        return n;
    }

    public int size() {
        return baseSize;
    }

    public boolean add(Customer customer) {
        if (baseSize >= n) {
            n = (int) (n * 1.5 + 1);
            resize(n);
        }
        baseSize++;
        int i = baseSize;
        base[i - 1] = customer;
        if (contains(customer)) return true;
        else return false;

    }

    public void resize(int newLength) {
        Customer[] newArray = new Customer[newLength];
        System.arraycopy(base, 0, newArray, 0, baseSize);
        base = newArray;
    }

    public Customer get(int i) {
        return base[i];
    }

    public boolean addAll(Customer[] array) {
        boolean res = false;
        for (int i = 0; i < array.length; i++) {
            this.add(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            if (contains(array[i])) res = true;
            else return false;
        }
        return res;
    }

    public void clear() {
        base = new Customer[n];
        baseSize = 0;
    }

    public boolean contains(Customer customer) {
        boolean c = false;
        int i = 0;
        while (i < baseSize && !c) {
            if (base[i].equals(customer)) c = true;
            i++;
        }
        return c;
    }

    public Customer remove(int index) {
        Customer customer = base[index];
        if (index < baseSize) {
            for (int i = index; i < baseSize; i++) {
                if (index == baseSize - 1) base[index] = null;
                else base[i] = base[i + 1];
            }
            baseSize--;
        } else System.out.println("нет такого индекса");
        return customer;
    }

    public int indexOf(Customer customer) {
        for (int i = 0; i < baseSize; i++) {
            if (base[i].equals(customer)) {
                return i;
            }
        }
        return -1;
    }

    public void set(int index, Customer customer) {
        if (index < baseSize) base[index] = customer;
    }

    public Customer[] toArray() {
        Customer[] array = new Customer[baseSize];
        for (int i = 0; i < baseSize; i++) {
            Customer c = new Customer();
            Address a = new Address();
            if (base[i].name != null) c.name = base[i].name;
            if (base[i].surname != null) c.surname = base[i].surname;
            c.age = base[i].age;
            if (base[i].address != null) {
                if (base[i].address.street != null) a.street = base[i].address.street;
                if (base[i].address.city != null) a.city = base[i].address.city;
                a.flatNumber = base[i].address.flatNumber;
                a.houseNumber = base[i].address.houseNumber;
                c.address = a;
            }
            array[i] = c;
        }
        return array;
    }

    public boolean isEmpty() {
        if (baseSize == 0) return true;
        else return false;
    }


}
