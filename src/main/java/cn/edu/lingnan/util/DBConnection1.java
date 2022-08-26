
package cn.edu.lingnan.util;

import java.sql.*;
import java.util.Map;

//功能： 处理数据库连接，做成单例模式
public class DBConnection1 {
    private static String driver= null;
    private static String url= null;
    private static String user= null;
    private static String password= null;
    private static String xsdName = "database.conf.xsd";
    private static String xmlName = "database.conf.xml";
    //保证连接也是唯一的
    private Connection conn=null;
    //单实例,设置为私有
    private static DBConnection1 dbConnection =null;
    static {
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String xsdPath = basePath + xsdName;
        String xmlPath = basePath + xmlName;
        if (XmlValidate.validate(xsdPath, xmlPath)) {

            Map<String, String> map = XmlParser.parser(xmlPath);
            driver = map.get("driver");
            url = map.get("url");
            user = map.get("user");
            password = map.get("password");
        }
    }

    //私有的构造方法，保证对象的唯一性
    private DBConnection1() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //静态工程方法
    public static DBConnection1 getInstance(){
        if (dbConnection==null)
            dbConnection = new DBConnection1();
        return dbConnection;
    }

    //获取数据库连接的方法
    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(url,user,password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //    释放资源，先后顺序
    public void closeConnection(Connection conn,Statement stat, ResultSet rs){
        try {
            if (rs != null)
                rs.close();
            if (stat != null)
                stat.close();
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //重载
    public void closeConnection(Connection conn,PreparedStatement prep, ResultSet rs){
        try {
            if (rs != null)
                rs.close();
            if (prep != null)
                prep.close();
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

//    //第一版本的获取数据库连接的方法
//    public static Connection getConnection() {
////      ______________________核心部分_______________________
//        Connection conn = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection
//                    ("jdbc:mysql://localhost/enterprise", "root", "111111");
//        } catch (ClassNotFoundException e) {
//            System.out.println("[Debug] Mysql的Jar包没有加载成功");
//            e.printStackTrace();
//        }// alt + enter 快捷键
//        catch (SQLException e) {
//            e.printStackTrace();
//        } //这里通常不需要再释放资源
//        return conn;
//    }
