package cn.edu.lingnan.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestJDBC03 {

    @Test
    public void test(){
        //配置信息
        String url = "jdbc:mysql://localhost:3306/company?userUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "111111";

        Connection connection =null;
        try {
            //1、加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、连接数据库，代表数据库
            connection= DriverManager.getConnection(url,username,password);

            //3、通知数据库开启事务
            connection.setAutoCommit(false);
            String sql = "update tb_account set money=money-100 where name = 'A'";
            connection.prepareStatement(sql).executeUpdate();

            //4、制造错误
            //int i = 1/0;

            String sql2 = "update tb_account set money=money+100 where name = 'B'";
            connection.prepareStatement(sql2).executeUpdate();

            connection.commit();//以上两条都执行成功了，就提交事务
            System.out.println("提交成功！");

        } catch (Exception e) {
            try {//如果出现异常，就通知数据库回滚事务
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
