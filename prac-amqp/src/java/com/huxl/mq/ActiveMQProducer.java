package com.huxl.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/**
 * @author huxl
 * @createDate 2018/1/26 8:57
 */
public class ActiveMQProducer {

    public static String BROKER_BIND_URL= "tcp://localhost:61616";
    public static String USER = ActiveMQConnectionFactory.DEFAULT_USER;
    public static String PASSWORD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Destination destination;
        Session session = null;

        connectionFactory = new ActiveMQConnectionFactory(USER,PASSWORD,BROKER_BIND_URL);
        try {
            connection = connectionFactory.createConnection();    //创建连接
            //创建会话 fase:不开启事务,AUTO_ACKNOWLEDGE:当客户端从receive或onMessage成功返回时，Session自动签收客户端的这条消息的收条
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            //消息队列，目的地
            destination = new ActiveMQQueue("hello.queue");
            //消息生产者
            MessageProducer producer = session.createProducer(destination);
            //消息
            TextMessage message = session.createTextMessage();
            message.setText("你好，这是消息内容");

            producer.send(message); //发送消息
        } catch (JMSException e) {
            e.printStackTrace();

        } finally {
            //关闭会话和连接
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
