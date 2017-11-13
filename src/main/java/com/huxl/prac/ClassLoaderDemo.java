package com.huxl.prac;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader classLoader = Demo.class.getClassLoader();
         classLoader.getParent();
    }

    class Demo {
        @Override
        public String toString() {
            return "classloader demo";
        }
    }
}
