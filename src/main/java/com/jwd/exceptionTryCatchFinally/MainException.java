package com.jwd.exceptionTryCatchFinally;

public class MainException {

    public static void main(String[] args) throws MyException {
//        throw new MyException("");
//        throw new MyRuntimeException();

        MyService myService = new MyService();

        try {
            m(myService);
        } catch (Exception e) {
            System.out.println("main()");
            System.out.println(e.getMessage());
            // e.printStackTrace(); // Not acceptable! in source code - only for debugging purposes.
        }
    }

    public static void m(MyService daoService) throws Exception {
        System.out.println("m() begins");
        try {
            System.out.println("begin try");
            daoService.process();
            String string = daoService.getString(false);
            if (string == null) {
                // ..
            } else {
                string.length();
            }
            System.out.println("end try");
        } catch (MyException e) {
            System.out.println(e.getMessage());
//            log.error("MainException#m() did work.");
            throw new ServiceLayerException(e);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
//            log.error("MainException#m() did work.");
            throw new ServiceLayerException(e);
        } finally {
            System.out.println("In any case we use this block.");
        }

        System.out.println("method m continues working correctly even in case of exceptions.");
        System.out.println("m() ends");
    }
}
