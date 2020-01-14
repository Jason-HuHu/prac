package com.huxl.invoke;

import java.lang.invoke.*;

import static java.lang.invoke.MethodHandles.lookup;

/**
 *invoke 指令演示
 * @author huxl
 * @since 2019/12/24-10:02
 */
public class InvokeDynamicTest {

    public static void main(String[] args) throws Throwable {
        INDY_BootstraoMethod().invokeExact("icyfenix");
    }

    public static void testMethod(String s) {
        System.out.println("hello String:" + s);
    }

    public static CallSite BootstrapMethod(MethodHandles.Lookup lookup,String name, MethodType mt) throws Throwable {
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class,name,mt));
    }

    private static MethodHandle INDY_BootstraoMethod() throws Throwable {
        CallSite cs = (CallSite) MH_BootstrapMethod().invokeWithArguments(lookup(),"testMethod", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V",null));

        return cs.dynamicInvoker();
    }

    private static MethodHandle MH_BootstrapMethod() throws NoSuchMethodException, IllegalAccessException {
        return lookup().findStatic(InvokeDynamicTest.class,"BootstrapMethod",MT_BootstrapMethod());
    }

    private static MethodType MT_BootstrapMethod() {
        return MethodType.fromMethodDescriptorString("(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/invoke/MethodType;)Ljava/lang/invoke/CallSite",null);
    }
}
