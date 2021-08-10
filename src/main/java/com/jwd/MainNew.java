package com.jwd;

import com.jwd.returnValue.AbstractClass;
import com.jwd.returnValue.ImplClass;

/*
override
1) access enlarges
2) return type specifies
 */
public class MainNew {
    public static void main(String[] args) {
        AbstractClass a = new ImplClass();
        String message = (String) a.getMessage();

        ImplClass b = new ImplClass();
        String message1 = b.getMessage();
    }
}
