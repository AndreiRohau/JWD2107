package com.jwd.pattern;

public class CustomProcessorImpl extends AbstractProcessor {


    public CustomProcessorImpl() {
        super();
    }

    @Override
    protected void processCustomPart() {
        System.out.println(string);
        System.out.println("this snippet runs by CustomProcessorImpl");
    }

    @Override
    protected String processCustomPart(int i) {
        return String.valueOf(i);
    }
}
