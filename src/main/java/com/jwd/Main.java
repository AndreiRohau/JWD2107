package com.jwd;

public class Main {
    /*
    logging levels
    ALL - logs all levels
    TRACE - traces + debugs + infos + warns + errors + fatals
    DEBUG - debugs + infos + warns + errors + fatals
    INFO - infos + warns + errors + fatals
    WARN - warns + errors + fatals
    ERROR - errors + fatals
    FATAL - logs only fatal
    OFF - totally stops logging
     */
    public static void main(String[] args) {
        // slf4j here doesnot have fatal method to log
        AnyProcessorSlf4j slf4j = new AnyProcessorSlf4j();
        slf4j.run(0, true);

        AnyProcessorLog4j log4j = new AnyProcessorLog4j();
        log4j.run(0, true);


//        logFor(log4j);
    }

    private static void logFor(AnyProcessorLog4j log4j) {
        for (int i = 0; i < 1_0; i++) {
            log4j.run(i);
        }
    }
}
