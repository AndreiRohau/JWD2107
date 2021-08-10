package com.jwd.pattern;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public abstract class AbstractProcessor {
    protected String string = "absctract";

    protected abstract void processCustomPart();

    protected abstract String processCustomPart(int i);
    public AbstractProcessor() {
        System.out.println();
    }

    public void process() {
        String text = "Hello boy";
        System.out.println(text);
        String s = Arrays.toString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(s);

        processCustomPart();
        String length = processCustomPart(s.length());

        System.out.println("length is " + length);
        System.out.println("Bye bye");
    }

}
