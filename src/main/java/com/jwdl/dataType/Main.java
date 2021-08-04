package com.jwdl.dataType;

public class Main {

    public static final String CONSTANTA = "MY_CONSTANT";
    public static final double PI_CUSTOM = 3.14;

    public static int mainStaticInt = 17;
    int mainInt = 17;

    public static void main(String[] args) {
        System.out.println(PI_CUSTOM * 6);
        //region
        byte b = 127;// [-128, 127]
        short sh = -129; // [-128, 127]
        int i = -12933333; // [-128, 127]
        long l = 333333333344555555L;
        long lo = 1_000_000_000L;

        float fl = 12.2f;
        double d = 13.4;

        boolean boolTrue = true;
        boolean boolFalse = false;

        char ch = 'd';
        String s = "d";

        System.out.println();

        Account account = new Account();
//        System.out.println(account.sum);

//        int integer; //0
//        System.out.println(integer);

        System.out.println(com.jwdl.dataType.Main.mainStaticInt);

        Main main = new Main();
        System.out.println(main.mainInt);
        main = null;
        System.out.println(mainStaticInt);
        //endregion
        System.out.println("+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_");
        System.out.println("+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_");
        System.out.println();

        Account myAccount = new Account();
        System.out.println(myAccount.getSum());

        myAccount.add(5);

        System.out.println(myAccount.getSum());

        System.out.println(myAccount.toString());
    }
}
