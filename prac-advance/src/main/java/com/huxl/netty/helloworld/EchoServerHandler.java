package com.huxl.netty.helloworld;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;


/**
 *  ChannelHandler 和业务逻辑
 *
 * 1.针对不同类型的事件来调用ChannelHandler
 * 2.应用程序通过实现或者扩展ChannelHandler来关联到事件的生命周期，并且提供自定义的应用程序逻辑
 * 3.在架构上，ChannelHandler有助于保持业务逻辑与网络处理代码的分离
 *
 * @author huxl
 * @since 2019/4/8 16:26
 */

@ChannelHandler.Sharable //标识一个ChannelHandler 可以被多个Channel安全地共享
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //以下可以实现业务逻辑

        ByteBuf in = (ByteBuf) msg;
        //打印消息到控制台
        System.out.println("Server received:" + in.toString(CharsetUtil.UTF_8));

        //将收到的消息写给发送者，而不刷新
        ctx.write(in);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //Flushes pending messages to the remote peer and closes the channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //Prints the exception stack trace
        cause.printStackTrace();
        //closes the channel
        ctx.close();
    }
}
