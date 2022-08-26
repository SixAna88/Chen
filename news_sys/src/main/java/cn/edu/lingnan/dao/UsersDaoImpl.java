package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Users;
import cn.edu.lingnan.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


/*
 * 作者： 许伟程
 * 描述： 用户的dao接口实现类
 * */

public class UsersDaoImpl implements UsersDao {

    public Vector<Users> selectAllUsers() {
        Vector<Users> vector = new Vector<Users>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_news_users";
            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();
            while (rs.next()) {
                Users users = new Users();
                users.setUserId(rs.getInt("userId"));
                users.setUsername(rs.getString("username"));
                users.setPassword(rs.getString("password"));
                users.setUserPhone(rs.getString("userPhone"));
                users.setUserAge(rs.getInt("userAge"));
                users.setBirth(rs.getDate("birth"));
                users.setRemark(rs.getString("remark"));
                vector.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    public Vector<Users> selectUsersById(int userId) {
        Vector<Users> vector = new Vector<Users>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            //3. 创建Sql语句对象
            String sql = "select * from tb_news_users where userId = ? ";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, userId);
            rs = prep.executeQuery();
            if (rs.next()) {
                Users users = new Users();
                users.setUserId(rs.getInt("userId"));
                users.setUsername(rs.getString("username"));
                users.setPassword(rs.getString("password"));
                users.setUserPhone(rs.getString("userPhone"));
                users.setUserAge(rs.getInt("userAge"));
                users.setRemark(rs.getString("remark"));
                vector.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    public Vector<Users> selectUsersByName(String username) {
        Vector<Users> vector = new Vector<Users>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_news_users where username like ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, "%" + username + "%");
            rs = prep.executeQuery();
            while (rs.next()) {
                Users users = new Users();
                users.setUserId(rs.getInt("userId"));
                users.setUsername(rs.getString("username"));
                users.setPassword(rs.getString("password"));
                users.setUserPhone(rs.getString("userPhone"));
                users.setUserAge(rs.getInt("userAge"));
                users.setRemark(rs.getString("remark"));
                vector.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    public Users UsersLogin(String username, String password) {
        Users users = new Users();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            //3. 创建Sql语句对象
            String sql = "select * from tb_news_users where username = ? and password = ? ";
            prep = conn.prepareStatement(sql);
            prep.setString(1, username);
            prep.setString(2, password);
            rs = prep.executeQuery();
            if (rs.next()) {
                users.setUserId(rs.getInt("userId"));
                users.setUsername(rs.getString("username"));
                users.setPassword(rs.getString("password"));
                users.setUserPhone(rs.getString("userPhone"));
                users.setUserAge(rs.getInt("userAge"));
                users.setRemark(rs.getString("remark"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return users;
    }

    public int UserRegister(String username, String password) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "insert into tb_news_users(username,password) values (?,?)";
            prep = conn.prepareStatement(sql);
            prep.setString(1,username);
            prep.setString(2,password);

            flag = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

    public int updateUsers(Users users) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "update tb_news_users set username = ? ,password = ? ," +
                    "userPhone = ? ,userAge = ? , birth = ? ,remark = ? where userId = ? ";
            prep = conn.prepareStatement(sql);
            prep.setString(1,users.getUsername());
            prep.setString(2,users.getPassword());
            prep.setString(3,users.getUserPhone());
            prep.setInt(4,users.getUserAge());
            prep.setDate(5,users.getBirth());
            prep.setString(6,users.getRemark());
            prep.setInt(7,users.getUserId());
            flag = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

    public int deleteUsers(int userId) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "delete from tb_news_users where userId = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, userId);
            flag = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

    public int insertUsers(Users users) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "insert into tb_news_users(username,password,userPhone,userAge,birth) values (?,?,?,?,?)";
            prep = conn.prepareStatement(sql);
            prep.setString(1,users.getUsername());
            prep.setString(2,users.getPassword());
            prep.setString(3,users.getUserPhone());
            prep.setInt(4,users.getUserAge());
            prep.setDate(5, users.getBirth());
            flag = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }
}
