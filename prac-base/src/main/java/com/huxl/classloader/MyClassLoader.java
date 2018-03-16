package com.huxl.classloader;

import java.io.FileInputStream;

/**
 * 自定义类加载器
 * @author huxl
 * @createDate 2018/3/16 17:06
 */
public class MyClassLoader extends ClassLoader {
    private String classPath;
    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

     private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.","/");
         FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
         int len = fis.available();
         byte[] data = new byte[len];
         fis.read(data);
         fis.close();
         return data;
     }

     protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            return defineClass(name,data,0,data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
     }
}
