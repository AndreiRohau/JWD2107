package com.jwd.daemon;

public class FlexiMain {
    public static void main(String[] args) {
        FlexibleThread normal = new FlexibleThread();
        FlexibleThread daemon = new FlexibleThread();
        daemon.setDaemon(true);

        daemon.start();
        normal.start();
        System.out.println("END OF MAIN");
        // you will not see end daemon - daemons can be closed my main
    }
}
