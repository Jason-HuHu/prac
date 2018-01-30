package com.huxl.io;

import java.io.*;

/**
 * @author huxl
 * @createDate 2018/1/24 16:09
 * java io 练习
 */
public class IOPrac {
    /**
     * question one :读取from.txt文件的内容 写到to.txt中,要求原文件的空行不写入新文件中
     */

    public static void main(String[] args) {
        String fromPath = "D:/from.txt";
        String toPath = "D:/to.txt";

        readAndWrite(fromPath, toPath);
    }

    public static void readAndWrite(String fromPath, String toPath) {
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            //输入流
//            FileInputStream fis = new FileInputStream(fromPath);
//            InputStreamReader isr = new InputStreamReader(fis);
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fromPath), "GBK"));

            //输出流
//            FileOutputStream fos = new FileOutputStream(toPath);
//            OutputStreamWriter osw = new OutputStreamWriter(fos);
            writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(toPath), "GBK"));

            String temp = null;
            while ((temp = reader.readLine()) != null) {
                if (temp.trim().equals("")) {
                    continue;
                }

                writer.println(temp);
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
