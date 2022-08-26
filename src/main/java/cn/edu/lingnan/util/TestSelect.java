package cn.edu.lingnan.util;

import cn.edu.lingnan.pojo.Guide;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class TestSelect {

    public static void main(String[] args) {
        Vector<Guide> vector = new Vector<Guide>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获取SQL执行对象
            String sql = "select * from tb_guide";
            rs = st.executeQuery(sql);//返回结果集

            //多条数据，用while
            while (rs.next()) {
                Guide guide = new Guide();
                guide.setGuideId(rs.getString("gid"));
                guide.setGuideName(rs.getString("gname"));
                guide.setPassword(rs.getString("password"));
                guide.setSuperuser(rs.getInt("superuser"));
                guide.setFlag(rs.getInt("flag"));
                vector.add(guide);
            }
            for (Guide guide : vector
            ) {
                System.out.println(guide);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }

    }
}
