package com.prac.rpc.dubbo.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.huxl.rpc.dubbo.spi.Robot;
import org.junit.Test;


public class DubboSPITest {

    @Test
    public void sayHello(){
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        System.out.println("Dubbo SPI");
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();

        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}
