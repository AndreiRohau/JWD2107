package com.jwd.base;

public class Entity extends AbstractEntity implements Int, Int2 {

    static void staticEntityClassM() {
        System.out.println("static Entity method");
    }

    public Entity(String abstractsString) {
        super(abstractsString);
    }

    public static void staticM() {
        System.out.println("static Int method");
    }

    public static void staticAbstractClassM() {
        System.out.println("static AbstractProcessor method");
    }

    @Override
    public void absM2() {
        AbstractEntity.staticAbstractClassM();
    }

    @Override
    public void interfaceM() {

    }

    @Override
    public String interfaceM(int i) {
        return null;
    }

    public void me1() {
        System.out.println("entity me1");
    }



    public void interfaceM2() {
        System.out.println("Int2");
    }
}
