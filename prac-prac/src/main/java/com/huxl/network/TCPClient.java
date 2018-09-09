package com.huxl.network;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 *
 * @author huxingl
 * @since 2018/8/20 9:31
 */


public class TCPClient {
    
    private static final String ip = "10.17.85.99";
    private static final int port = 7500;
    
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        PrintWriter writer = null;
    
        InputStream inputStream = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
    
        try {
            socket = new Socket(ip,port);
            outputStream = socket.getOutputStream();
            writer = new PrintWriter(outputStream);
            writer.print("hello server");
            writer.flush();
            socket.shutdownOutput();
        
            inputStream = socket.getInputStream();
            reader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(reader);
            String info = "";
            String temp = null;
            while ((temp = bufferedReader.readLine()) != null) {
                info += temp;
                System.out.println(info);
            }
        
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        
            if (writer != null) {
                writer.close();
            }
        
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
