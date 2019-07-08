package com.prac.rpc.dubbo.spi;

import com.huxl.rpc.dubbo.spi.Robot;
import org.junit.Test;

import java.util.ServiceLoader;

/**
 * Java原生SPI机制
 * @author huxl
 * @since 2019/6/25 19:27
 */
public class JavaSPITest {

    @Test
    public void sayHello(){
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
