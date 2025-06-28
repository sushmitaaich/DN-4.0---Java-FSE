package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderLogging {
    private static final Logger logger = LoggerFactory.getLogger(AppenderLogging.class);

    public static void main(String[] args) {
        logger.info("This message will appear in console and app.log file.");
        logger.debug("Debug log with timestamp.");
        logger.warn("Warning message for logback demo.");
    }
}
