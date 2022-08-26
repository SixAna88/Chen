package cn.edu.lingnan.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获取SQL执行对象
            String sql = "insert into tb_guide values('g20','admin20','111',0,1)";
            int i = st.executeUpdate(sql);//受影响行数
            if(i>0){
                System.out.println("插入成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,null);
        }

    }
}
