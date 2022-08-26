package cn.edu.lingnan.test;

import java.sql.*;

public class TestJDBC02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        String url = "jdbc:mysql://localhost:3306/company?userUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "111111";

        //1、加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2、连接数据库，代表数据库
        Connection connection = DriverManager.getConnection(url,username,password);

        //3、编写sql语句
        String sql = "insert into tb_guide(gid,gname,password,superuser,flag) values (?,?,?,?,?);";

        //4、预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //为占位符赋值，第一个属性为参数位置，第二个为值
        preparedStatement.setString(1,"g08");
        preparedStatement.setString(2,"admin7");
        preparedStatement.setString(3,"admin7");
        preparedStatement.setInt(4,1);
        preparedStatement.setInt(5,1);
//        preparedStatement.setDate(5,new Date( new java.util.Date().getTime()));

        //5、执行sql
        int i = preparedStatement.executeUpdate();

        if(i>0){
            System.out.println("插入成功！");
        }
        //6、关闭连接，释放资源（先开的后关）
        preparedStatement.close();
        connection.close();
    }
}
