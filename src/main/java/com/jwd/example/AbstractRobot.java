package com.jwd.example;

public abstract class AbstractRobot implements Robot {

    @Override
    public void switchOnRobot() {
        welcomeMaster();
        runCustomProcess();
        charge();
    }

    protected abstract void runCustomProcess();

    private void welcomeMaster() {
        System.out.println("Welcome my master");
    }

    private void charge() {
        System.out.println("Going to charger...");
    }


}
