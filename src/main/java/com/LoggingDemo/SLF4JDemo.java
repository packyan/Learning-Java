package com.LoggingDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JDemo {
    final Logger logger = LoggerFactory.getLogger(getClass());
    protected void get(int i){
        logger.info("sadsa info");
        logger.warn("warn");
        logger.error("error");
    }
    public static void main(String[] args) {
        SLF4JDemo slf4JDemo = new SLF4JDemo();
        slf4JDemo.get(1);
    }

}
