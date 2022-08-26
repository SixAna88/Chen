package cn.edu.lingnan.util;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidate {
    //输入XSD和XML文件，来验证XML文件的有效性
    public static boolean validate(String xsdName,String xmlName) {
        boolean flag = false;
        try {
            //1. 创建模式工厂SchemaFactory
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            //2. 通过XSD文件创建模式Schema
            File file = new File(xsdName);
            Schema schema = schemaFactory.newSchema(file);
            //3. 由模式创建验证器Validator
            Validator validator = schema.newValidator();
            //4. 使用验证器验证XML文件
            Source source =new StreamSource(xmlName);
            validator.validate(source);
            flag = true;
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("[Debug] :  XSD文件在验证XML文件时出现错误！");
            e.printStackTrace();
        }
        return flag;
    }
}