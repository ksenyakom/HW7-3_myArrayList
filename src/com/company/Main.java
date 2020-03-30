package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        customerClass customers = new customerClass(initBase());
        System.out.println("*** Создаем массив");
        printBase(customers);

        customers.clear();
        System.out.println("\n*** clear очищаем массив");
        printBase(customers);

        Customer c = new Customer("Петя", "Сашин", 25);
        customers.add(c);
        System.out.println("\n*** add Добавили Петю Сашина - ");
        printBase(customers);

        System.out.println("\n*** contains Содержит ли база Петю Сашина - " + customers.contains(c));

        c = customers.get(0);
        System.out.println("\n*** get " + c.name + " " + c.surname);

        Customer c1 = new Customer("Петя", "Сашин", 25);
        System.out.println("\n*** equals " + c.name + " = " + c1.name + " " + c.equals(c1));

        customers.addAll(initBase());
        System.out.println("\n*** addAll ");
        printBase(customers);

        customers.remove(1);
        System.out.println("\n*** remove(1) ");
        printBase(customers);

        System.out.println("\n*** indexOf (Петя Сашин) " + customers.indexOf(c1));

        Customer c2 = new Customer("Billie", "Eilish", 25);
        customers.set(0, c2);
        System.out.println("\n*** set (0,Billie Eilish) ");
        printBase(customers);

        Customer[] array = new Customer[customers.baseSize];
        array = customers.toArray();

        System.out.println("\n*** Преобразовали в массив " + array.toString());
        array[0].name = "Джозефина";
        for (int i = 0; i < array.length; i++) System.out.println(array[i].toString());

        System.out.println("\n*** isEmpty " + customers.isEmpty());

        // Переполняем наш ArrayList
        System.out.println("\n *** Увеличиваем размер масссива");
        System.out.println("Размер массива до: " + customers.getN());
        customers.addAll(initBase());
        customers.addAll(initBase());
        customers.addAll(initBase());

        printBase(customers);
        System.out.println("Размер массива после: " + customers.getN());

    }

    public static Customer[] initBase() {
        Address address1 = new Address("Минск", "Победителей", 5);
        Address address = new Address("Минск", "Победителей", 1, 1);
        Customer c1 = new Customer("Вася", "Пупкин", 33, address1);
        Customer c2 = new Customer("Катя", "Пупкина", 30, address);
        Customer c3 = new Customer("Аполлон", "Пупкин", 45);
        Customer[] base = new Customer[3];
        base[0] = c1;
        base[1] = c2;
        base[2] = c3;
        return base;
    }

    public static void printBase(customerClass customers) {
        System.out.println("База покупателей:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.base[i].toString());
        }
        if (customers.size() == 0) System.out.println("База пуста");
    }
}
