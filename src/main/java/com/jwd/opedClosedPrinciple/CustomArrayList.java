package com.jwd.opedClosedPrinciple;

import java.util.ArrayList;
import java.util.logging.Logger;

public class CustomArrayList<T> extends ArrayList<T> {

    private static final Logger LOGGER = Logger.getLogger(CustomArrayList.class.getName());

    @Override
    public T get(int index) {
        LOGGER.info("my a little bit custom list has getter logging");
        LOGGER.info("gettting object with index=" + index);
        return super.get(index);
    }


}
