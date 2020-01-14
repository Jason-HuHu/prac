package com.huxl.eshore.fileserver.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author huxl
 * @since 2019/12/20-14:22
 */
public class Client {
    private Socket client;
    private boolean connected;
    //构造方法
    public Client(String host,int port){
        try {
            //创建Socket对象
            client = new Socket(host,port);
            System.out.println("服务器连接成功！");
            this.connected = true;
        } catch (UnknownHostException e) {
            System.out.println("无法解析的主机！");
            this.connected = false;
        } catch (IOException e) {
            System.out.println("服务器连接失败！");
            this.connected = false;
            closeSocket();
        }
    }
    //判断是否连接成功
    public boolean isConnected(){
        return connected;
    }
    //设置连接状态
    public void setConnected(boolean connected){
        this.connected = connected;
    }
    /**
     * 发送文件方法
     * @param localFileName 本地文件的全路径名
     * @param remoteFileName 远程文件的名称
     */
    public void sendFile(String localFileName, String remoteFileName){
        DataOutputStream dos = null; //写Socket的输出流
        DataInputStream dis = null;  //读取本地文件的输入流
        if(client==null) {return;}
        File file = new File(localFileName);
        //检查文件是否存在
        if(!file.exists()){
            System.out.println("本地文件不存在，请查看文件名是否写错！");
            this.connected = false;
            this.closeSocket();
            return;
        }
        try {
            //初始化本地文件读取流
            dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            //将指令和文件发送到Socket的输出流中
            dos = new DataOutputStream(client.getOutputStream());
            //将远程文件名发送出去
            dos.writeUTF("put "+remoteFileName);
            //清空缓存，将文件名发送出去
            dos.flush();
            //开始发送文件
            int bufferSize = 10240;
            byte[] buf = new byte[bufferSize];
            int num =0;
            while((num=dis.read(buf))!=-1){
                dos.write(buf, 0, num);
            }
            dos.flush();
            System.out.println("文件发送成功！");
        } catch (IOException e) {
            System.out.println("文件传输错误！");
            closeSocket();
        } finally{
            try {
                dis.close();
                dos.close();
            } catch (IOException e) {
                System.out.println("输入输出错误！");
            }
        }
    }
    /**
     * 接收文件方法
     * @param remoteFileName 本地文件的全路径名
     * @param localFileName  远程文件的名称
     */
    public void receiveFile(String remoteFileName, String localFileName){
        DataOutputStream dos = null; //写Scoket的输出流
        DataInputStream dis = null;  //读Socket的输入流
        DataOutputStream localdos = null; //写本地文件的输出流
        if(client==null) {return;}
        try {
            localdos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(localFileName)));
            //将指令和文件名发送到Socket的输出流中
            dos = new DataOutputStream(client.getOutputStream());
            //将远程文件名发送出去
            dos.writeUTF("get "+remoteFileName);
            dos.flush();
            //开始接收文件
            dis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            int bufferSize = 10240;
            byte[] buf = new byte[bufferSize];
            int num = 0;
            while((num=dis.read(buf))!=-1){
                localdos.write(buf, 0, num);
            }
            localdos.flush();
            System.out.println("数据接收成功！");
        } catch (FileNotFoundException e) {
            System.out.println("文件没有找到！");
            closeSocket();
        } catch (IOException e) {
            System.out.println("文件传输错误！");
        } finally {
            try {
                dos.close();
                localdos.close();
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //关闭端口
    public void closeSocket(){
        if(client!=null){
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 主方法调用上述方法
     * @param args
     * 将本地文件上传到远程服务器
     * put[-h hostname][-p portname]local_filename remote_filename
     * 从远程服务器上下载文件
     * get[-h hostname][-p portname]remote_filename local_filename
     */
    public static void main(String[] args){
        //服务器默认端口为8888
        if(args.length != 7){
            System.out.println("参数数目不正确！");
            return;
        }
        String hostName = args[2];
        int port = 0;
        String localFileName = "";
        String remoteFileName = "";
        Client client = null;
        try {
            port = Integer.parseInt(args[4]);
        } catch (NumberFormatException e) {
            System.out.println("端口号输出格式错误！");
            return;
        }
        if(args[0].equals("put")){
            //上传文件
            client = new Client(hostName,port);
            localFileName = args[5];
            remoteFileName = args[6];
//            System.out.println(remoteFileName);
            if(client.isConnected()){
                client.sendFile(localFileName, remoteFileName);
                client.closeSocket();
            }
        }else if(args[0].equals("get")){
            //下载文件
            client = new Client(hostName,port);
            localFileName = args[6];
            remoteFileName = args[5];
            if(client.isConnected()){
                client.receiveFile(remoteFileName, localFileName);
                client.closeSocket();
            }
        }else{
            System.out.println("命令输入不正确，正确命令格式如下：");
            System.out.println("put -h hostname -p portname local_filename remote_filename");
            System.out.println("get -h hostname -p portname remote_filename local_filename");
        }
    }
}
