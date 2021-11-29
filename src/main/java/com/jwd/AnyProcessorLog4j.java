package com.jwd;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AnyProcessorLog4j {
    private static final Logger LOGGER = LogManager.getLogger(AnyProcessorLog4j.class);

    public void run(int i) {
        String message = "info text message : " + i;
        LOGGER.info(message);
        LOGGER.debug(message);

        LOGGER.warn(message);
        LOGGER.error(message);
        LOGGER.trace(message);

        LOGGER.fatal(message);

    }

    public void run(int i, boolean isNew) {
        LOGGER.trace(AnyProcessorSlf4j.class.getName() + "#run(" + i + ", " + isNew + ")");
        String message = complexConcatenation(i);
        LOGGER.debug(message);
        try {
            LOGGER.info("info about something");
            LOGGER.info("info about something");
            LOGGER.warn("warning about something important but not critical");
            if (isNew) {
                throw new Exception("isNew!!!!");
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            LOGGER.fatal(e.getMessage());
//            throw new CustomLayeredException(e);
        } finally {
            LOGGER.trace("check if all resources closed and log the result");
        }
    }

    private String complexConcatenation(int i) {
        return "info text message : " + i;
    }
}
