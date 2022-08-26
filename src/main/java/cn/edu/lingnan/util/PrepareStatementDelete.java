package cn.edu.lingnan.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareStatementDelete {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            conn = JdbcUtils.getConnection();//获取数据库连接
            //区别
            String sql = "delete from tb_guide where gid=?";//使用问号占位符
            prep = conn.prepareStatement(sql);//预编译SQL  先写sql,然后不执行

            //手动赋值，从下标1开始
            prep.setString(1,"g21");
            //执行sql
            int i = prep.executeUpdate();//不用传sql

            if(i>0){
                System.out.println("删除成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,prep,null);
        }
    }
}
