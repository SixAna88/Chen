package cn.edu.lingnan.test;

import java.sql.*;

public class TestJDBC01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        String url = "jdbc:mysql://localhost:3306/company?userUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "111111";

        //1、加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2、连接数据库，代表数据库
        Connection connection = DriverManager.getConnection(url,username,password);

        //3、向数据库发送SQL的对象Statement、PreparedStatement : CRUD
        Statement statement = connection.createStatement();

        //4、编写sql语句
        String sql = "select * from tb_guide";

//        //受影响行数，增删改都是用executeUpdate(sql);
//        int num= statement.executeUpdate(sql);

        //5、执行sql,返回一个结果集
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("______________________________________________________");
        while(resultSet.next()){
            System.out.println("id        =   " + resultSet.getObject("gid"));
            System.out.println("gname     =   " + resultSet.getObject("gname"));
            System.out.println("password  =   " + resultSet.getObject("password"));
            System.out.println("superuser =   " + resultSet.getObject("superuser"));
            System.out.println("flag      =   " + resultSet.getObject("flag"));
            System.out.println("______________________________________________________");
        }

        //6、关闭连接，释放资源（先开的后关）
        resultSet.close();
        statement.close();
        connection.close();
    }
}
