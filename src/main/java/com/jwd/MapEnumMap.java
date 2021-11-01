package com.jwd;

import java.util.EnumMap;

public class MapEnumMap {
    public static void main(String[] args) {
        EnumMap<Religion, String> map = new EnumMap<>(Religion.class);
        map.put(Religion.ISLAM, "Koran");
        System.out.println(map.get(Religion.ISLAM));

    }
}
