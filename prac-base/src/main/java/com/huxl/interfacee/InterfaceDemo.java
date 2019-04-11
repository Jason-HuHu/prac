package com.huxl.interfacee;

/**
 * 接口的定义
 *
 *  静态方法必须有方法体
 *  抽象方法不能有方法体
 *  接口的默认修饰符 public abstract
 * @author huxl
 * @since 2019/4/11 17:05
 */
public class InterfaceDemo {

    public static void main(String[] args) {
        new D().print();
        System.out.println(Type.A);
        int s,h,e;

//        (h * 10 + e) * (h * 10 +e)
    }


    interface A{
        void print();
    }

    interface B{
        static void print(){

        };
    }

    abstract interface C extends A,B{
        @Override
        abstract void print();
    }

    static class D implements C{
        @Override
        public void print() {
            System.out.println(D.class.getSimpleName());
        }
    }
}

enum Type{
    /**
     *
     * */
    A,B,C;
    private Type(){
        System.out.println("1");
    }
}
