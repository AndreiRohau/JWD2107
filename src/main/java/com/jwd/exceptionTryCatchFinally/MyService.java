package com.jwd.exceptionTryCatchFinally;

public class MyService {
    public void process() throws MyException {
        System.out.println("process starts");
        // ... processing
        throw new MyException("I have produced an exception...");
    };

    public String getString(boolean isTrue) {
        String result;
        if (isTrue) {
            result = "string";
        } else {
            result = null;
        }
        return result;
    }
}
