package com.jwd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        // fully synchronized
        Collection<Object> synchronizedCollection = Collections.synchronizedCollection(new ArrayList<>());
        // partially synchronized. during mutable processes works with a copy of array
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    }
}
