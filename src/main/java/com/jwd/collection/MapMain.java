package com.jwd.collection;

import java.util.HashMap;
import java.util.Map;

public class MapMain {
    static Map<Integer, String> postcodeToCity = new HashMap<>();
    // 123451 - Minsk
    // 123461 - Brest - BLR
    // 234511 - Brest - France

    public static void main(String[] args) {
        postcodeToCity.put(null, "Default city");
        postcodeToCity.put(1115, "Minsk");
        print(postcodeToCity);
        postcodeToCity.put(1116, "Brest");
        print(postcodeToCity);
        postcodeToCity.put(1117, "Brest");
        print(postcodeToCity);
        postcodeToCity.put(1118, "Stub");
        print(postcodeToCity);
        postcodeToCity.put(1118, "Restub");
        print(postcodeToCity);
        System.out.println();
    }

    public static void print(Map<Integer, String> map) {
        System.out.println("##############################");
        for (Integer key : map.keySet()) {
            System.out.println("[Key; Value] : [" + key + "; " + map.get(key) + "]");
        }
    }
}
