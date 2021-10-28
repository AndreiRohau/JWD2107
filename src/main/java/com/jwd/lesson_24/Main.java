package com.jwd.lesson_24;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("4");
        linkedList.add("a");
        linkedList.add("d");
        linkedList.forEach(System.out::println);
        linkedList.sort(Comparator.naturalOrder()); // where have implementation
        System.out.println();
        linkedList.forEach(System.out::println);
        System.out.println();

        HashSet<String> states = new HashSet<>();

        // добавим в список ряд элементов
        states.add("Germany");
        states.add("Belarus");
        states.add("France");
        states.add("Italy");
        states.add("Italy");
        // пытаемся добавить элемент, который уже есть в коллекции
        boolean isAdded = states.add("Germany");
        System.out.println(isAdded);    // false

        System.out.printf("Set contains %d elements \n", states.size());    // 3

        for(String state : states){

            System.out.println(state);
        }
        // удаление элемента
        states.remove("Germany");

        // хеш-таблица объектов Person
    }
}
