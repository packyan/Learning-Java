package com.LoggingDemo;

import java.util.logging.Logger;

public class JDKLoggingDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();
        logger.info("tesing start");
        logger.warning("warning ..");
        logger.fine("good fine");
        logger.severe("!!!! severe");
    }
}
