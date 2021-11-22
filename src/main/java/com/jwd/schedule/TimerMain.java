package com.jwd.schedule;

import java.util.Timer;

public class TimerMain {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Temp(), 2000, 8);
    }
}
