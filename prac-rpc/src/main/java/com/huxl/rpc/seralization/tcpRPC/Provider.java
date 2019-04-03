package com.huxl.rpc.seralization.tcpRPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huxl
 * @createDate 2017/10/30 14:40
 */
public class Provider {
//    private Map<String,Object> services = new HashMap<>();
//    public void setServices(Map services){
//        this.services = services;
//    }
//    SayHelloServiceImpl sayHelloService = new SayHelloServiceImpl();


    public static void main(String[] args) throws IOException, ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<String,Object> services = new HashMap<>();
        SayHelloService sayHelloService = new SayHelloServiceImpl();
        services.put("com.huxl.seralization.tcpRPC.SayHelloService",sayHelloService);
        ServerSocket server = null;
        try {
             server = new ServerSocket(1234);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            Socket socket = null;
            try {
                 socket = server.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //读取服务信息
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            //接口名称
            String interfaceName = ois.readUTF();
            //方法名称
            String methodName = ois.readUTF();
            //方法参数类型
            Class<?>[] paramerterTypes = (Class<?>[]) ois.readObject();
            //参数对象
            Object[] arguments = (Object[]) ois.readObject();
            //执行调用
            Class serviceInterfaceClass = Class.forName(interfaceName);
            Object service =  services.get(interfaceName);

            //获得要调用的方法
            Method method = serviceInterfaceClass.getMethod(methodName,paramerterTypes);
            Object result = method.invoke(service,arguments);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(result);
        }
    }
}
