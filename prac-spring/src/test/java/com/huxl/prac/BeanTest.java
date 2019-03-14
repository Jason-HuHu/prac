package com.huxl.prac;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runners.model.InitializationError;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

/**
 * 测试用例
 *
 * @author xiaoh
 * @since 2019/3/12 9:45
 */
public class BeanTest extends TestCase {

    public BeanTest() {
    }

    public void testBean(){
        System.out.println("test bean");
        //过时的方法
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyBean myBean = beanFactory.getBean(MyBean.class);
        assertEquals("mybean",myBean.getName());
        SpringDemo springDemo = beanFactory.getBean(SpringDemo.class);
        springDemo.setDemo("springdemo");
        assertEquals("springdemo",springDemo.getDemo());

//        springDemo.setMyBean(myBean);
        assertEquals(myBean,springDemo.getMyBean());
    }

    public void testResource(){
        ClassLoader loader = BeanTest.class.getClassLoader();
        System.out.println("BeanTest's ClassLoader:" + loader.toString() );
        System.out.println("BeanTest's ClassLoader 's parent:" + loader.getParent().toString());
    }

    public void testClassloader(){
        Properties properties =  System.getProperties();
        try {
            properties.list(new PrintStream(new FileOutputStream("properties.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //BootStarpClassLoader
        System.out.println("sun.boot.class.path:" + System.getProperty("sun.boot.class.path"));
        //ExtClassloader
        System.out.println("java.ext.dirs:" + System.getProperty("java.ext.dirs"));
        //AppClassLoader
        System.out.println("java.class.path:" + System.getProperty("java.class.path"));

        //测试加载顺序

    }
}
