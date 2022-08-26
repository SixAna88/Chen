package cn.edu.lingnan.test;

import cn.edu.lingnan.util.XmlParser;
import cn.edu.lingnan.util.XmlValidate;

import java.util.Map;

public class XmlTest {
    public static void main(String[] args) {
        String xsdName = "database.conf.xsd";
        String xmlName = "database.conf.xml";
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String  xsdPath = basePath + xsdName;
        String  xmlPath = basePath + xmlName;

        //第一种写法，采用绝对路径读取文件
        System.out.println(XmlValidate.validate(xsdPath, xmlPath));

        if (XmlValidate.validate(xsdPath, xmlPath)){

            Map<String,String> map = XmlParser.parser(xmlPath);
            System.out.println(map.get("driver"));
            System.out.println(map.get("url"));
            System.out.println(map.get("user"));
            System.out.println(map.get("password"));

        }

//        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
//        System.out.println(XmlValidate.validate("D:\\IDEAWorkspace\\JavaWebProject\\M-JDBC\\target\\classes\\database.conf.xsd", "D:\\IDEAWorkspace\\JavaWebProject\\M-JDBC\\target\\classes\\database.conf.xml"));

        //
    }
}
