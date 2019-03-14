package com.huxl.prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Spring 源码解析Demo
 *
 * @author xiaoh
 * @since 2019/3/11 15:36
 */
@Service
public class SpringDemo {
    @Autowired
    private MyBean myBean;

    private String demo;

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    public MyBean getMyBean() {
        return myBean;
    }

    public void setMyBean(MyBean myBean) {
        this.myBean = myBean;
    }
}
