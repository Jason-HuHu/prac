package com.huxl.prac.spring_base;

import com.huxl.spring_base.service.IMonkeyService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huxl
 * @createDate 2018/1/17 10:10
 */
public class AOPMain {
    public static void main(String[] args) {
        String contenxtPath = "classpath:conf.spring/spring_base_applicationContext.xml";
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(contenxtPath);

        IMonkeyService studentService =  beanFactory.getBean(IMonkeyService.class);
        studentService.touTaozi();
    }
}
