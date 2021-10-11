package com.jwd.opedClosedPrinciple;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Human extends Shape implements DrawableBeing {
    @Override
    public double countArea() {
        throw new NotImplementedException();
    }

    @Override
    public String drawAnfas() {
        //...
        return null;
    }

    @Override
    public String drawProfile() {
        //...
        return null;
    }
}
