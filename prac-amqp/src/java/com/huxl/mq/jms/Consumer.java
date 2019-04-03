package com.huxl.mq.jms;

import com.huxl.mq.jms.domain.Spittle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huxl
 * @createDate 2018/1/26 16:41
 */
public class Consumer {

    public static void main(String[] args){
        String contextPath = "classpath:conf.spring/spring-jms.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(contextPath);

        SpittleAlertHandler handler = (SpittleAlertHandler) context.getBean("spittleHandler");
        Spittle spittle = new Spittle();
        handler.handleSpittleAlert(spittle);


    }
}
