package com.huxl.seralization;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author huxl
 * @createDate 2017/10/30 9:16
 */
public class Hessian {
    Person zhansan = new Person("zhansan",23);

    public byte[] out(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //Hessian序列化输出
        HessianOutput ho = new HessianOutput(outputStream);

        try {
            ho.writeObject(zhansan);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] zhansanByte = outputStream.toByteArray();
        System.out.println(zhansanByte);
        return zhansanByte;
    }

    public void read(byte[] bytes){
        ByteArrayInputStream io = new ByteArrayInputStream(bytes);
        HessianInput hi = new HessianInput(io);
        try {
            Person person = (Person) hi.readObject();
            System.out.println(person.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Hessian hessian = new Hessian();
        hessian.out();
        hessian.read(hessian.out());
    }


}
