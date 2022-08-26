package cn.edu.lingnan.util;

import cn.edu.lingnan.pojo.Guide;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class PrepareStatementSelect {
    public static void main(String[] args) {

        Vector<Guide> vector = new Vector<Guide>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();//获取数据库连接
            //区别
            String sql = "select * from tb_guide where gid = ?";//使用问号占位符

            prep = conn.prepareStatement(sql);//预编译SQL  先写sql,然后不执行

            //手动赋值，从下标1开始
            prep.setString(1, "g21");
            //执行sql
            rs = prep.executeQuery();//不用传sql

            while (rs.next()) {
                Guide guide = new Guide();
                guide.setGuideId(rs.getString("gid"));
                guide.setGuideName(rs.getString("gname"));
                guide.setPassword(rs.getString("password"));
                guide.setSuperuser(rs.getInt("superuser"));
                guide.setFlag(rs.getInt("password"));
                vector.add(guide);
            }

            for (Guide guide: vector
                 ) {
                System.out.println(guide);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, prep, null);
        }
    }
}
