package com.huxl.designpattern.proxy;

/**
 * @author huxl
 * @createDate 2018/3/16 11:25
 */
public class ProxyImage implements Image{
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }


}
