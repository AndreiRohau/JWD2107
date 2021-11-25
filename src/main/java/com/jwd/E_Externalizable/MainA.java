package com.jwd.E_Externalizable;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MainA {
    private static final String OUTPUT_FILE_COUNTRY = "data\\country1.dat";
    private static final String OUTPUT_FILE_REGION = "data\\region1.dat";

    @Test
    public void whenSerializing_thenUseExternalizable_country() {

        Country serializing = new Country();
        serializing.setCode(374);
        serializing.setName("Armenia");

        serialize(OUTPUT_FILE_COUNTRY, serializing);

        Country unfrozen = new Country();
        deserialize(OUTPUT_FILE_COUNTRY, unfrozen);

        assertEquals(unfrozen.getCode(), serializing.getCode());
        assertEquals(unfrozen.getName(), serializing.getName());
    }

    @Test
    public void whenSerializing_thenUseExternalizable_region() {

        Region serializing = new Region();
        serializing.setCode(374);
        serializing.setName("Armenia");
        serializing.setClimate("Mediterranean");
        serializing.setPopulation(120.000);

        serialize(OUTPUT_FILE_REGION, serializing);

        Region unfrozen = new Region();
        deserialize(OUTPUT_FILE_REGION, unfrozen);

        assertEquals(unfrozen.getCode(), serializing.getCode());
        assertEquals(unfrozen.getName(), serializing.getName());
    }

    private <T extends Externalizable> void deserialize(String path, T object) {
        try (FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            object.readExternal(objectInputStream);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private <T extends Externalizable> void serialize(String path, T object) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {
            object.writeExternal(objectOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
