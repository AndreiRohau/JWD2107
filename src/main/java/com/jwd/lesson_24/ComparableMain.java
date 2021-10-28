package com.jwd.lesson_24;

import java.util.TreeSet;

public class ComparableMain {
    public static void main(String[] args) {

        TreeSet<User> states = new TreeSet<>();

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
    }
}
