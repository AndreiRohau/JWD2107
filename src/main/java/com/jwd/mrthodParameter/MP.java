package com.jwd.mrthodParameter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class MP {
    public static void main(String... args) {

//        print(null);
//        print(null, new String[]{"2 message"});
//        print(null, new String[]{"3 message"});
//
//        print(null, "11 msg", "22 msg"); // here
//        print(null, "11 msg", "22 msg", "33 msg");
//        print(null, "11 msg", "22 msg", "33 msg", "44 msg");
//        print(null, "11 msg", "22 msg", "33 msg", "44 msg");
//
//        String[] strings = new String[]{"a", "b", "c"};
//
//        print("msg", strings);
////////////////////////////////////

        Integer[] ints = {1,2,3,4};
        List<Integer> list = Arrays.asList(ints);  // ArrayList is a custom static array in Arrays Class != java.util.ArrayList
        ArrayList arr = new ArrayList(list);
//        for (int i = 0; i < 1000; i++) {
//            list.add(i + 100);
//        }

        System.err.println(Arrays.toString(ints));
        System.err.println(list);
        System.err.println(arr);
        ints[1] = 11111;
        System.err.println(Arrays.toString(ints));
        System.err.println(list);
        System.err.println(arr);

//        String str = "";
//        boolean aNull = nonNull(str.isEmpty());
    }

    public static void print(String sss, String... strings) {
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
