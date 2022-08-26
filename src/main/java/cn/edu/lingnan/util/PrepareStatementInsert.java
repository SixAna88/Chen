package cn.edu.lingnan.util;

import java.sql.*;

public class PrepareStatementInsert {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            conn = JdbcUtils.getConnection();//获取数据库连接
            //区别
            String sql = "insert into tb_guide values(?,?,?,?,?)";//使用问号占位符
            prep = conn.prepareStatement(sql);//预编译SQL  先写sql,然后不执行

            //手动赋值，从下标1开始
            prep.setString(1,"g21");
            prep.setString(2,"admin21");
            prep.setString(3,"123456");
            prep.setInt(4,1);
            prep.setInt(5,1);
            //执行sql
            int i = prep.executeUpdate();//不用传sql

            if(i>0){
                System.out.println("插入成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,prep,null);
        }
    }
}
