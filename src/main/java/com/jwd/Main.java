package com.jwd;

import com.jwd.opedClosedPrinciple.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape square = new Square(4);
        Shape circle = new Circle(5);
        final List<Shape> list = new CustomArrayList<>();
        list.add(square);
        list.add(circle);
//        list.add(new Human());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
