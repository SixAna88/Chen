package cn.edu.lingnan.util;

import java.sql.*;

public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        1、加载驱动
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");//固定写法，8.0以上版本要加cj

//        2、用户信息和url
        String url = "jdbc:mysql://localhost:3306/company?useUnicode=true&characterEncoding=utf-8&useSSL=true";
        String username= "root";
        String password= "111111";

//        3、连接成功，数据库对象  Connection 代表数据库(获取数据库连接)
        Connection connection = DriverManager.getConnection(url, username, password);

//        4、执行sql的对象 Statement
        Statement statement  = connection.createStatement();

//        5、执行sql，可能存在结果，查看返回结果
        String sql = "select * from tb_guide";
//        查询的结果集对象，封装所有的查询结果
        ResultSet resultSet = statement.executeQuery(sql);

//        statement.executeQuery(); 查询操作，返回结果集
//        statement.execute(); 执行所有sql
//        statement.executeUpdate(); 更新操作，返回受影响行数(增、删、改)

        /*
        获得指定的数据类型
        resultSet.getString();
        resultSet.getInt();
        resultSet.getFloat();
        resultSet.getDate();
        resultSet.getObject();
        ...
         */

        /*
        遍历、指针
        resultSet.beforeFirst(); //移动到最前面
        resultSet.afterLast(); //移动到最后面
        resultSet.next(); //移动到下一行
        resultSet.previous(); //移动到上一行
        resultSet.absolute(row); //移动到指定行
         */

//        链表形式
        while(resultSet.next()){
            System.out.println("id  "+ resultSet.getObject("gid"));
            System.out.println("name  "+ resultSet.getObject("gname"));
            System.out.println("password  "+ resultSet.getObject("password"));
            System.out.println("superuser  "+ resultSet.getObject("superuser"));
            System.out.println("flag  "+ resultSet.getObject("flag"));
            System.out.println("===================================");
        }
//        6、释放连接，“先开后关”原则
        resultSet.close();
        statement.close();
        connection.close();

    }
}
