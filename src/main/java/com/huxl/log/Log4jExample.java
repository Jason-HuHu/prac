package com.huxl.log;

import org.apache.log4j.Logger;

/**
 * @author huxl
 * @createDate 2017/12/18 14:29
 */
public class Log4jExample {
    static Logger log = Logger.getLogger(Log4jExample.class.getName());
    public static void main(String[] args) {
        log.info("hello,this is info message");
        log.debug("hello,this is debug messgae");

    }
}
