package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingLevelsDemo {
    private static final Logger logger = LoggerFactory.getLogger(LoggingLevelsDemo.class);

    public static void main(String[] args) {
        logger.trace("This is a TRACE level message");
        logger.debug("This is a DEBUG level message");
        logger.info("This is an INFO level message");
        logger.warn("This is a WARN level message");
        logger.error("This is an ERROR level message");
    }
}
