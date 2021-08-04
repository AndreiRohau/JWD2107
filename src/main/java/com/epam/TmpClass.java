package com.epam;

public class TmpClass extends AbstractTmpClass implements TmpInterface, TmpInterfaceSecond {

    public static final String FINAL_STRING = "HELLO!!!";
    // events - Listeners

    // data - состояние
    String tmpString;
    int tmpInt;

    // functions - поведение - свойства
    private void tmpFunction() {

    }
    private void tmpFunction(String s) {

    }

    public static String tmpStaticFunction() {
        return "static call";
    }

    // constructors
    public TmpClass() {
    }

    public TmpClass(String string) {
        this.tmpString = string;
    }

    void abstractMethod() {

    }
}
