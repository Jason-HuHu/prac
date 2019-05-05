package com.huxl.netty;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * 未使用Netty的阻塞网络编程
 *
 * @author huxl
 * @since 2019/5/5 19:08
 */
public class PlainOioServer {
    public void server(int port) throws IOException{
        final ServerSocket socket = new ServerSocket(port);
        try {
            for (;;){
                //接收连接
                final Socket clientSocket = socket.accept();
                System.out.println("Accepted connection from " + clientSocket);
                //创建一个新的线程来处理该请求
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream out;
                        try {
                            out = clientSocket.getOutputStream();
                            out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                        }catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            try {
                                clientSocket.close();
                            }catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
