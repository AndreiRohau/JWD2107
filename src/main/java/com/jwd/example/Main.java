package com.jwd.example;

public class Main {
    public static void main(String[] args) {
        Robot defender = new WarMachineRobot();
        Robot houser = new HouseMaidRobot();

        defender.switchOnRobot();
        houser.switchOnRobot();
    }
}
