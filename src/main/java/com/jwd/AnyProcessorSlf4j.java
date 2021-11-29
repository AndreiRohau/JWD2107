package com.jwd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnyProcessorSlf4j {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnyProcessorSlf4j.class);

    public void run(int i) {
        String message = "info text message : " + i;
        LOGGER.info(message);

        LOGGER.debug(message);

        LOGGER.warn(message);
        LOGGER.error(message);
        LOGGER.trace(message);
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
//            throw new CustomLayeredException(e);
        } finally {
            LOGGER.trace("check if all resources closed and log the result");
        }
    }

    private String complexConcatenation(int i) {
        return "info text message : " + i;
    }
}
