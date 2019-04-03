package com.huxl.mq.jms;


import com.huxl.mq.jms.domain.Spittle;
import org.springframework.stereotype.Component;

@Component
public class SpittleAlertHandler {

  public void handleSpittleAlert(Spittle spittle) {
    System.out.println(spittle.getMessage());
    System.out.print(spittle.getId());
  }

}
