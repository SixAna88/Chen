package cn.edu.lingnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCutil {
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/enterprise";
    private static String username="root";
    private static String password="111111";
    private static Connection conn=null;
    private static PreparedStatement ps=null;
    private static ResultSet res=null;
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //数据库连接
    public static void getConnection() {
        try {
            conn= DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    /**
     * 数据库的增删改
     * @param sql 传进来的sql语句
     * @param obj 对象数组
     * @return 返回操作的数据条数
     */
    public static int update(String sql,Object[] obj) {
        getConnection();
        int num=0;
        try {
            ps=conn.prepareStatement(sql);
            if (obj!=null) {
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i+1, obj[i]);
                }
            }
            num=ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            close();
        }
        return num;
    }
    /**
     * 数据库查询
     * @param sql 传入查询sql语句
     * @param obj 传入对象数组
     * @return 返回一个resultset结果集
     */
    public static ResultSet select(String sql,Object[] obj) {
        getConnection();
        try {
            ps=conn.prepareStatement(sql);
            if (obj!=null) {
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i+1, obj[i]);
                }
            }
            res=ps.executeQuery();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return res;
    }

    public static void close() {
        try {
            if (ps!=null) {
                ps.close();
            }
            if (conn!=null) {
                conn.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
