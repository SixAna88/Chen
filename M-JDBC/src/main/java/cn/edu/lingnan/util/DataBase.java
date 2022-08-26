package cn.edu.lingnan.util;

import java.sql.*;

public class DataBase {

    private String driver="com.mysql.cj.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/company";
    private String user="root";
    private String password="111111";
    //单实例,设置为私有
    private static DataBase dbConnection =null;
    //保证连接也是唯一的
    private Connection conn=null;
    //私有的构造方法，保证对象的唯一性

    private DataBase() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //静态工程方法
    public static DataBase getInstance(){
        if (dbConnection==null)
            dbConnection = new DataBase();
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
    public void closeConnection(Connection conn, Statement stat, ResultSet rs){
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
