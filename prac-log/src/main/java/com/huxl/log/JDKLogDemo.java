package com.huxl.log;

import java.util.logging.*;

/**
 * jdk 自带的日志框架
 * @see java.util.logging
 *
 * @author huxl
 * @since 2019/4/3 16:15
 */
public class JDKLogDemo {

    private static final Logger logger = Logger.getLogger(JDKLogDemo.class.getName());

    public static void main(String[] args) {

        logger.info("test jdk logging");
    }
}
