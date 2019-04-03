package com.huxl.mq.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author huxl
 * @createDate 2018/1/26 15:59
 */
public class JMSTemplateProducer {


    public static void main(String[] args) {
        String contextPath = "classpath:conf.spring/spring-jms.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(contextPath);
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
        jmsTemplate.send("spittle.alert.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("sss");//创建消息
            }
        });

        TextMessage message = (TextMessage) jmsTemplate.receive();
        try {
            System.out.println(message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }


    }
}
