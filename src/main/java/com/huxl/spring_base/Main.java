package com.huxl.spring_base;

import com.huxl.spring_base.service.IStudentService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huxl
 * @createDate 2018/1/17 10:10
 */
public class Main {
    public static void main(String[] args) {
        String contenxtPath = "classpath:conf.spring/spring_base_applicationContext.xml";
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(contenxtPath);

        IStudentService studentService =  beanFactory.getBean(IStudentService.class);
        IStudentService studentService1 =  beanFactory.getBean(IStudentService.class);
        System.out.println(studentService.getSudentCount());
    }
}
