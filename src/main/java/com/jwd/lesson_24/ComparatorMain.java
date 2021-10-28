package com.jwd.lesson_24;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorMain {
    public static void main(String[] args) {
        TreeSet<User> states = new TreeSet<>(new UserByNameComparator());

        // добавим в список ряд элементов
        states.add(new User("D", 13));
        states.add(new User("Cc", 14));
        states.add(new User("C", 14));
        states.add(new User("A", 17));
        states.add(new User("B", 10));

        System.out.printf("TreeSet contains %d elements \n", states.size());

        for(User state : states){

            System.out.println(state);
        }

        TreeSet<User> statesAged = new TreeSet<>(new UserByAgeComparator());

        // добавим в список ряд элементов
        statesAged.add(new User("D", 13));
        statesAged.add(new User("Cc", 14));
        statesAged.add(new User("C", 14));
        statesAged.add(new User("A", 17));
        statesAged.add(new User("B", 10));

        System.out.printf("TreeSet contains %d elements \n", statesAged.size());

        for(User state : statesAged){

            System.out.println(state);
        }

        Comparator<User> namedAgedComparator = new UserByNameComparator().thenComparing(new UserByAgeComparator());
        TreeSet<User> statesNamedAged = new TreeSet<>(namedAgedComparator);

        // добавим в список ряд элементов
        statesNamedAged.add(new User("D", 13));
        statesNamedAged.add(new User("C", 176));
        statesNamedAged.add(new User("C", 16));
        statesNamedAged.add(new User("A", 17));
        statesNamedAged.add(new User("B", 10));

        System.out.printf("TreeSet contains %d elements \n", statesNamedAged.size());

        for(User state : statesNamedAged){

            System.out.println(state);
        }
    }
}
