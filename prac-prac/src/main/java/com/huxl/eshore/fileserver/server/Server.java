package com.huxl.eshore.fileserver.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端，用于接收上传的数据 和 供用户下载
 * @author huxl
 * @since 2019/12/20-11:48
 */
public class Server {
    private int port;
    private String host;
    private String dirPath;
    private static ServerSocket server = null;

    public Server(int port,String dirPath){
        this.port = port;
        this.dirPath = dirPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDirPath() {
        return dirPath;
    }

    public void setDirPath(String dirPath) {
        this.dirPath = dirPath;
    }

    public static ServerSocket getServer() {
        return server;
    }

    public static void setServer(ServerSocket server) {
        Server.server = server;
    }

    public void run(){
        if(server==null){
            try {
                server = new ServerSocket(port);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("服务已启动...");
        while(true){
            try {
                //通过ServerSocket的accept方法建立连接,并获取客户端的Socket对象
                Socket client = server.accept();
                if(client==null) {continue;}
                new SocketConnection(client,this.dirPath).run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
