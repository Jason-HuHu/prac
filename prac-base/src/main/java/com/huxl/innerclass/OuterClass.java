package com.huxl.innerclass;

/**
 * 内部类
 *  非静态内部类
 *  静态内部类
 * @author huxingl
 * @since 2018/7/31 8:59
 */


public class OuterClass {
    
    private static String outerStaticName = "outerStaticName";
    private String outerName;
    
    public void getUsage(){
        System.out.println("this is outer class! outerName =" + this.outerName);
    }
    
    public void getInnerclass(){
        InnerClass innerClass = new InnerClass();
        innerClass.setInnerName("INNER_NAME");
        innerClass.getUsage();
    }
    
    public void getInnerStaticClass(){
        InnerStaticClass innerStaticClass = new InnerStaticClass();
        innerStaticClass.setInnerStaticName("INNER_STATIC_NAME");
    
        
        innerStaticClass.getUsage();
    }
    
    private class InnerClass{
        private String innerName;
    
        public void getUsage(){
            System.out.println("this is inner class! innerName = " + this.innerName);
        }
        
        public String getInnerName() {
            return innerName;
        }
    
        public void setInnerName(String innerName) {
            this.innerName = innerName;
        }
    }
    
    private static class InnerStaticClass{
        public static String staticName = "STATICNAME";
        private String innerStaticName;
        
        public void getUsage(){
            System.out.println("this is innerStatic class! innerStaticName = " + this.innerStaticName);
        }
        
        public String getInnerStaticName() {
            return innerStaticName;
        }
    
        public void setInnerStaticName(String innerStaticName) {
            this.innerStaticName = innerStaticName;
        }
    }
    
    public static String getOuterStaticName() {
        return outerStaticName;
    }
    
    public static void setOuterStaticName(String outerStaticName) {
        OuterClass.outerStaticName = outerStaticName;
    }
    
    public String getOuterName() {
        return outerName;
    }
    
    public void setOuterName(String outerName) {
        this.outerName = outerName;
    }
    
    
    public static void main(String[] args) {
        System.out.println("实例化外部类： new OuterClass()");
        OuterClass outerClass = new OuterClass();
    
        System.out.println("通过外部类实例化一个非静态内部类");
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
    
        System.out.println("调用非静态内部类的方法");
        innerClass.setInnerName("INNER_CLASS");
        innerClass.getUsage();
    
        System.out.println("调用静态内部类的静态变量");
        System.out.println(InnerStaticClass.staticName);
    
        System.out.println("不依赖外部类实例，直接实例化静态内部类");
        OuterClass.InnerStaticClass innerStaticClass = new InnerStaticClass();
        innerStaticClass.setInnerStaticName("INNER_STATIC_NAME");
        innerStaticClass.getUsage();
    
    }
}
