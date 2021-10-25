package com.jwd;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        // Collection extends Serializable, Cloneable
        // before java2
        // threadsafe
        Vector<Integer> v;
        Stack<Integer> st;
        Hashtable<Integer, String> ht;
        BitSet bts;
        Enumeration<String> emrtn;

        // java5
        // java.util.concurrent
        CopyOnWriteArrayList<String> concurentList = new CopyOnWriteArrayList<>();
        ArrayList<String> arr = new ArrayList<>();


        // Stack -> LIFO -> last in first out
        // очередь -> FIFO -> first in first out
        Collection c; // коллекция
        List l; // список
        Set s; // неповторяющееся множество
        Queue q; // очередь

        Map m;
    }

    // connection
    // preparedStatement
    // resultSet
    // *** autocloseable

    /*
        Stack<Autocloseable> s = new Stack();
        s.add(connection);
        s.add(preparedStatement);
        s.add(resultSet);

        for(Autocloseable a : s) {
            a.close();
        }
     */
}
