package cn.edu.lingnan.utils;

import java.sql.*;


/*
* 作者： 许伟程
* 描述： JDBC工具类封装
* 内容： 连接数据库、释放资源
* */

//功能： 处理数据库连接，做成单例模式
public class DBConnection {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/db_news";
    private String user = "root";
    private String password = "111111";
    //单实例,设置为私有
    private static DBConnection dbConnection = null;
    //保证连接也是唯一的
    private Connection conn = null;

//    由 public 改为 private，保证唯一性,并要创建get和set方法

    //私有的构造方法，保证对象的唯一性
    private DBConnection() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //静态工程方法
    public static DBConnection getInstance() {
        if (dbConnection == null)
            dbConnection = new DBConnection();
        return dbConnection;
    }

    //获取数据库连接的方法
    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //释放资源，先开后关
    public void closeConnection(Connection conn, Statement stat, ResultSet rs) {
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
}

