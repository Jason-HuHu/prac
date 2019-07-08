package com.huxl.rpc.dubbo.spi;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * 接口定义
 *
 * @author huxl
 * @since 2019/6/25 19:10
 */
@SPI
public interface Robot {

    void sayHello();

}
