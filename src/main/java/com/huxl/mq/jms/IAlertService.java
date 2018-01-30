package com.huxl.mq.jms;

import com.huxl.mq.jms.domain.Spittle;

/**
 * @author huxl
 * @createDate 2018/1/26 16:00
 */
public interface IAlertService {

    void senSpittleAlert(Spittle spittle);
}
