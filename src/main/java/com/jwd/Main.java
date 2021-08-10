package com.jwd;

import com.jwd.base.AbstractEntity;
import com.jwd.base.Entity;
import com.jwd.base.Int;
import com.jwd.base.Int2;
import com.jwd.pattern.AbstractProcessor;
import com.jwd.pattern.CustomProcessorImpl;
import com.jwd.pattern.ProcessorImpl;

public class Main {

    private static AbstractProcessor abstractProcessor;
    public static void main(String[] args) {
        AbstractEntity abstractEntity = new Entity("");
        abstractEntity.m1();

        Entity entity = new Entity("");
        entity.m1();
        entity.me1();
        entity.interfaceM2();
        Entity.staticAbstractClassM();
        Int.staticM();
        Int2.staticM();

        //Int anonymousInterface = () -> System.out.println("так делать нельзя");
        //anonymousInterface.interfaceM();

        System.out.println("----------------");
        abstractProcessor = new ProcessorImpl();
        abstractProcessor.process();
        System.out.println("----------------");
        abstractProcessor = new CustomProcessorImpl();
        abstractProcessor.process();
        System.out.println("----------------");
        abstractProcessor = new AbstractProcessor() {
            @Override
            protected void processCustomPart() {
                System.out.println("this snippet runs by 100% custom implementation");
            }

            @Override
            protected String processCustomPart(int i) {
                return String.valueOf(i);
            }
        };
        abstractProcessor.process();
        System.out.println("----------------");
        Entity.staticAbstractClassM();
        //AbstractEntity.staticAbstractClassM();
        Int.staticM();


    }
}
