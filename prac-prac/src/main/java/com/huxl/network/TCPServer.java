package com.huxl.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 *
 * @author huxingl
 * @since 2018/8/20 9:31
 */


public class TCPServer {
    private static final int port = 7500;
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
    
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);
                
                outputStream = socket.getOutputStream();
                printWriter = new PrintWriter(outputStream);
                String info = "";
                String temp = "";
                while ((temp = bufferedReader.readLine()) != null) {
                    info += temp;
                    System.out.println(info);
                    printWriter.write("server accept ：" + info);
                    printWriter.flush();
                }
                socket.shutdownOutput();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
