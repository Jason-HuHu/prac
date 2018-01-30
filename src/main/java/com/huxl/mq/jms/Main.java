package com.huxl.mq.jms;

import com.huxl.mq.jms.domain.Spitter;
import com.huxl.mq.jms.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author huxl
 * @createDate 2018/1/26 16:41
 */
public class Main {

    public static void main(String[] args){
        String contextPath = "classpath:conf.spring/spring-jms.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(contextPath);

        IAlertService alertService = context.getBean(IAlertService.class);
        Spitter spitter = new Spitter(1L,"username","password","xiaom","12@qq.com",false);
        Spittle spittle = new Spittle(1L,spitter,"sss",new Date());
        alertService.senSpittleAlert(spittle);


    }
}
