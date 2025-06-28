package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {
        String user = "Sush";
        int score = 95;

        logger.info("User {} has a score of {}", user, score);
        logger.debug("Debug: User {} attempted score logging at {}", user, System.currentTimeMillis());
        logger.warn("Warning: Score for user {} might be outdated", user);
        logger.error("Error: Unable to update score for user {}", user);
    }
}
