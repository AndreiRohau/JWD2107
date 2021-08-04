package com.jwdl1.dataType;

public class Account {
    private String accountNamePrimary = "Andrei's default account";
    private String accountNameSecondary = "Andrei's default account";
    private int sum; // 0
    Account account; // null

    public void add(int пополнение) {
        int tmp;
        tmp = sum;
        sum = пополнение + tmp;
        if (1 > 0) {
            int localBlockInt = 9;
            System.out.println(tmp);
            System.out.println(localBlockInt);
        }
        System.out.println(tmp);
//        System.out.println(localBlockInt);
    }

    public void pay() {

    }

    public int getSum() {
        return sum;
    }

    public String toString() {
        return "sum=" + sum + ", account=" + account;
    }
}
