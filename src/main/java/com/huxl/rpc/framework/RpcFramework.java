package com.huxl.rpc.framework;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author huxl
 * @createDate 2018/1/9 18:43
 * learn from http://javatar.iteye.com/blog/1123915
 */
public class RpcFramework {
    /**
     * 暴露服务
     *
     * @param service 暴露的服务对象
     * @param port    服务提供的端口
     * @throws Exception
     */
    public static void export(final Object service, int port) throws Exception {
        if (service == null) {
            throw new IllegalArgumentException("service instance == null");
        }

        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port: " + port);
        }

        System.out.println("Export Service " + service.getClass().getName() + " on port" + port);

        ServerSocket server = new ServerSocket(port);
        for (; ; ) {
            try {
                //监听端口等待请求
                final Socket socket = server.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            try {
                                //获取对象流
                                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

                                try {
                                    //方法名称
                                    String methodName = input.readUTF();
                                    System.out.println("export methodName :" + methodName);
                                    //参数类型
                                    Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                                    System.out.println("export parameterTypes: " + parameterTypes.toString());
                                    //参数值
                                    Object[] arguments = (Object[]) input.readObject();
                                    System.out.println("export arguments: " + arguments);

                                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());


                                    try {
                                        Method method = service.getClass().getMethod(methodName, parameterTypes);
                                        Object result = method.invoke(service, arguments);
                                        output.writeObject(result);
                                    } catch (Throwable t) {
                                        output.writeObject(t);
                                    } finally {
                                        output.close();
                                    }

                                } finally {
                                    input.close();
                                }
                            } finally {
                                socket.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 引用服务
     * @param interfaceClass 接口类
     * @param host 主机地址          z
     * @param port 引用地址端口
     * @param <T>  引用类型
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <T> T refer(final Class<T> interfaceClass, final String host, final int port) throws Exception {

        if (interfaceClass == null) {
            throw new IllegalArgumentException("Interface class == null");
        }

        if (!interfaceClass.isInterface()) {
            throw new IllegalArgumentException("The " + interfaceClass.getName() + " must be interface class!");
        }

        if (host == null || host.length() == 0) {
            throw new IllegalArgumentException("host == null");
        }

        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port :" + port);
        }

        System.out.println("Get Remote service " + interfaceClass.getName() + "from server :" + host + ":" + port);

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Socket socket = new Socket(host, port);
                try {
                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                    try {
                        output.writeUTF(method.getName());
                        output.writeObject(method.getParameterTypes());
                        output.writeObject(args);

                        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                        try {
                            Object result = input.readObject();
                            System.out.println("refer result :" + result);
                            if (result instanceof Throwable) {
                                throw (Throwable) result;
                            }
                            return result;
                        } finally {
                            input.close();
                        }
                    } finally {
                        output.close();
                    }
                } finally {
                    socket.close();
                }
            }
        });
    }
}
