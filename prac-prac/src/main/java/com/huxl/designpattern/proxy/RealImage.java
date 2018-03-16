package com.huxl.designpattern.proxy;

/**
 * @author huxl
 * @createDate 2018/3/16 11:23
 */
public class RealImage implements Image{
    private String fileName;
    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk();
    }
    @Override
    public void display() {
        System.out.println("Diplaying " + fileName);
    }

    private void loadFromDisk() {
        System.out.println("Loaging " + fileName);
    }
}
