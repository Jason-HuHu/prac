package com.huxl.designpattern.proxy;

/**
 * 需要使用RealImage时，使用Proxyimage来获取
 * @author huxl
 * @createDate 2018/3/16 11:46
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        RealImage realImage = new RealImage("sss.png");
        realImage.display();
        realImage.display();
        realImage.display();


        Image image = new ProxyImage("test.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");

        //图像不需要再次从磁盘加载
        image.display();
        image.display();
        image.display();
    }
}
