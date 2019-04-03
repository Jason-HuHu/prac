package com.huxl.rpc.seralization.tcpRPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author huxl
 * @createDate 2017/10/30 14:30
 */
public class Consumer {
    public static void main(String[] args) throws NoSuchMethodException, IOException {
        System.out.println("-------Consumer Start--------");
        //接口名称
        String interfaceName = SayHelloService.class.getName();

        //需要远程执行的方法
        Method method = SayHelloService.class.getMethod("sayHello",String.class);

        //需要传递到远端的参数
        Object[] arguments = {"hello"};

        Socket socket = new Socket("127.0.0.1",1234);

        //将方法名称和参数传递到远端
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        oos.writeUTF(interfaceName);//接口名称
        oos.writeUTF(method.getName());//方法名称
        oos.writeObject(method.getParameterTypes());
        oos.writeObject(arguments);

        //从远端读取方法执行结果

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        try {
            Object result = ois.readObject();
            System.out.println("远程方法执行结果result:" + result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
