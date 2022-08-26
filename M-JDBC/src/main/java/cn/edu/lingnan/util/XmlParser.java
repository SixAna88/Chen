
package cn.edu.lingnan.util;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//解析XML文件，返回值：
public class XmlParser {
    public static Map<String,String> parser(String xmlPath){
        Map<String,String> map = new HashMap<String, String>();

        try {
            //实例化一个解析工厂 SAXParserFactory对象
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //通过factory 获取一个SAXParser对象，即SAX解析器
            SAXParser saxParser = factory.newSAXParser();
            //saxParser对象调用parse方法解析XML文件
            File file = new File(xmlPath);
            XmlHandler xmlHandler = new XmlHandler();
            saxParser.parse(file,xmlHandler);
            map = xmlHandler.getMap();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}