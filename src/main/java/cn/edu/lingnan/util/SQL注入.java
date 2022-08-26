package cn.edu.lingnan.util;

import cn.edu.lingnan.pojo.Guide;

import java.sql.*;
import java.util.Vector;

public class SQL注入 {
    public static void main(String[] args) {

//        login("admin","admin");
        login("'or'1=1", "'or'1=1");//SQL注入

    }


    public static void login(String username, String password) {

        Connection conn = null;
//        Statement st = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();//获取数据库连接

            String sql ="select * from tb_guide where `gname` =? and `password` = ?";
//            st = conn.createStatement();//获取SQL执行对象
            prep = conn.prepareStatement(sql);
//            String sql = "select * from tb_guide where `gname` = '" + username + "' and `password` = '" + password + "'";
//            String sql = "select * from tb_guide where `gname` = ''or'1=1' and `password` = ''or'1=1'";

//            rs = st.executeQuery(sql);//返回结果集
            rs = prep.executeQuery();

            //多条数据，用while
            while (rs.next()) {
                System.out.println(rs.getString("gname"));
                System.out.println(rs.getString("password"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, prep, rs);
        }

    }
}
