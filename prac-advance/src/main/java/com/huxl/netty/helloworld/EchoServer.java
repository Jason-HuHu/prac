package com.huxl.netty.helloworld;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;

/**
 * 服务端引导 Bootstraping the server
 *
 * @author huxl
 * @since 2019/4/8 16:42
 */
public class EchoServer {

    private final int port;


    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage:" + EchoServer.class.getSimpleName() + "<port>");
        }

        //Sets the port value(throws a NumberFormatException if the port argements is malformed)
        int port = Integer.parseInt(args[0]);

        //calls the server's start() method
        new EchoServer(port).start();
    }

    public void start() throws InterruptedException {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        //1.Creates the EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            //2.Creates the ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    //3.指定所使用的NIO传输Channel Specifies the use of an NIO transport Channel
                    .channel(NioServerSocketChannel.class)
                    //4. 使用指定的端口设置套接字地址  Sets the socket address using the specified port
                    .localAddress(new InetSocketAddress(port))
                    //5. 添加一个ServerHandler 到子Channel 的ChannelPipeline;
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //EchoServerHandler 被标注为@Shareable，所以我们总可以使用同样的实例
                            ch.pipeline().addLast(serverHandler);
                        }
                    });

            //6.异步地绑定服务器，调用sync()方法阻塞等待直到绑定完成
            ChannelFuture future = b.bind().sync();
            //7.获取channel的CloseFuture，并且阻塞当前线程直到它完成
            future.channel().closeFuture().sync();
        }finally {

            //8.关闭EventLoopGroup，释放所有资源
            group.shutdownGracefully().sync();

        }
    }
}
