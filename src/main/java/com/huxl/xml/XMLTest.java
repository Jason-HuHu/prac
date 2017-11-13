package com.huxl.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

public class XMLTest {
    public static void main(String [] args){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(new File("F:\\codeworkspace\\java\\prac\\src\\main\\java\\com\\huxl\\XML\\applicationContext_TestXml.XML"));
            System.out.println(document.getName());

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Element root = document.getRootElement();
        String rootName = root.getName();
        String rootType = root.getNodeTypeName();

        System.out.println("rootName:" + rootName + "rootType:" + rootType);
    }
}
