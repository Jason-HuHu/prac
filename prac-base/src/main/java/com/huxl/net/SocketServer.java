package com.huxl.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 *
 * @author huxl
 * @since 2019/4/8 9:09
 */
public class SocketServer {
    private static final int PORT = 8848;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        Socket clientSocket = serverSocket.accept();

        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(),true);

        String request,response;

        while ((request = reader.readLine()) != null) {
            if ("Done".equals(request)) {
                break;
            }

            response = processRequest(request);

            printWriter.println(response);
        }

        //...省略资源关闭
    }

    private static String processRequest(String request){
        return "process : " +  request + "done";
    }
}
