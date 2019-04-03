package com.huxl.mq.jms;

import com.huxl.mq.jms.domain.Spittle;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author huxl
 * @createDate 2018/1/26 16:13
 */
@Component
public class AlertServiceImpl implements IAlertService {
    @Resource(name = "jmsTemplate")
    private JmsOperations jmsOperations;

    @Override
    public void senSpittleAlert(final Spittle spittle) {
        jmsOperations.send("spittle.alert.queue.test", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(spittle);//创建消息
            }
        });
    }
}
