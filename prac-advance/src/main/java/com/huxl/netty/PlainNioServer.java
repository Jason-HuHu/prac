package com.huxl.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 未使用Netty的异步网络编程
 * @author huxl
 * @since 2019/5/5 19:26
 */
public class PlainNioServer {
    public void serve(int port) throws IOException{

        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        serverChannel.configureBlocking(false);
        InetSocketAddress address = new InetSocketAddress(port);

        ServerSocket serverSocket = serverChannel.socket();
        //将服务器绑定到指定的端口
        serverSocket.bind(address);

        //打开Selector来处理channel;
        Selector selector = Selector.open();

        //将ServerSocket注册到Selector以接受连接
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        final ByteBuffer msg = ByteBuffer.wrap("Hi\r\n".getBytes());

        for (;;) {
            try {
                //等待需要处理的新事件；阻塞，将一直持续到下一个传入事件
                selector.select();
            }catch (IOException e) {
                e.printStackTrace();
                break;
            }
            //获取所有接收事件的SelectionKey实例
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();

           while (iterator.hasNext()) {
               SelectionKey key = iterator.next();
               iterator.remove();

               try {
                   //检测事件是否是一个新的已经就绪可以接受的连接
                   if (key.isAcceptable()) {
                       ServerSocketChannel server = (ServerSocketChannel) key.channel();
                       SocketChannel client = server.accept();
                       client.configureBlocking(false);
                       client.register(selector,SelectionKey.OP_WRITE|SelectionKey.OP_READ,msg.duplicate());

                       System.out.println("Accepted connection from " + client);

                   }

                   //检查套接字是否已经准备好写数据
                   if (key.isWritable()) {
                       SocketChannel client = (SocketChannel) key.channel();
                       ByteBuffer buffer = (ByteBuffer) key.attachment();

                       while (buffer.hasRemaining()) {
                           //将数据写到已连接的客户端
                           if (client.write(buffer) == 0) {
                               break;
                           }
                       }

                       client.close();
                   }

               }catch (IOException ex) {
                   ex.printStackTrace();

                   key.cancel();
                   try {
                       key.channel().close();
                   }catch (Exception e) {
                        e.printStackTrace();
                   }
               }
           }
        }

    }
}
