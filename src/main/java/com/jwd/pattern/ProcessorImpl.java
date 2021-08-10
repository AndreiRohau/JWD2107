package com.jwd.pattern;

public class ProcessorImpl extends AbstractProcessor {

    @Override
    protected void processCustomPart() {
        System.out.println(string);
        System.out.println("this snippet runs by ProcessorImpl");
    }

    @Override
    protected String processCustomPart(int i) {
        return String.valueOf(i);
    }
}
