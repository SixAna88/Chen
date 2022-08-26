package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Admin;
import cn.edu.lingnan.utils.DBConnection;

import java.sql.*;
import java.util.Vector;

/*
 * 作者： 许伟程
 * 描述： 管理员的dao接口实现类
 * */


public class AdminDaoImpl implements AdminDao {

    public Vector<Admin> selectAllAdmin() {
        Vector<Admin> vector = new Vector<Admin>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_news_admin";
            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setRole(rs.getInt("role"));
                admin.setCreateDate(rs.getDate("createDate"));
                admin.setMail(rs.getString("mail"));
                admin.setPhone(rs.getString("phone"));
                admin.setAge(rs.getInt("age"));
                admin.setRemark1(rs.getString("remark1"));
                admin.setRemark2(rs.getString("remark2"));
                admin.setRemark3(rs.getString("remark3"));
                vector.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    public Admin selectAdminById(int id) {
        Admin admin = new Admin();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            //3. 创建Sql语句对象
            String sql = "select * from tb_news_admin where id = ? ";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, id);
            rs = prep.executeQuery();
            if (rs.next()) {//对象唯一，可以用if
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setRole(rs.getInt("role"));
                admin.setCreateDate(rs.getDate("createDate"));
                admin.setMail(rs.getString("mail"));
                admin.setPhone(rs.getString("phone"));
                admin.setAge(rs.getInt("age"));
                admin.setRemark1(rs.getString("remark1"));
                admin.setRemark2(rs.getString("remark2"));
                admin.setRemark3(rs.getString("remark3"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return admin;
    }

    public Vector<Admin> selectAdminByRole(int role) {
        Vector<Admin> vector = new Vector<Admin>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_news_admin where role = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, role);
            rs = prep.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setRole(rs.getInt("role"));
                admin.setCreateDate(rs.getDate("createDate"));
                admin.setMail(rs.getString("mail"));
                admin.setPhone(rs.getString("phone"));
                admin.setAge(rs.getInt("age"));
                admin.setRemark1(rs.getString("remark1"));
                admin.setRemark2(rs.getString("remark2"));
                admin.setRemark3(rs.getString("remark3"));
                vector.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    public Vector<Admin> selectAdminByName(String username) {
        Vector<Admin> vector = new Vector<Admin>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_news_admin where username like ?";
            prep = conn.prepareStatement(sql);//预编译，不执行sql
            prep.setString(1, "%" + username + "%");
            rs = prep.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setRole(rs.getInt("role"));
                admin.setCreateDate(rs.getDate("createDate"));
                admin.setMail(rs.getString("mail"));
                admin.setPhone(rs.getString("phone"));
                admin.setAge(rs.getInt("age"));
                admin.setRemark1(rs.getString("remark1"));
                admin.setRemark2(rs.getString("remark2"));
                admin.setRemark3(rs.getString("remark3"));
                vector.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    public Vector<Admin> selectAdminByNameAndRole(String username, int role) {
        Vector<Admin> vector = new Vector<Admin>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_news_admin where username like ? and role = ?";
            prep = conn.prepareStatement(sql);//预编译，不执行sql
            prep.setString(1, "%" + username + "%");
            prep.setInt(2, role);
            rs = prep.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setRole(rs.getInt("role"));
                admin.setCreateDate(rs.getDate("createDate"));
                admin.setMail(rs.getString("mail"));
                admin.setPhone(rs.getString("phone"));
                admin.setAge(rs.getInt("age"));
                admin.setRemark1(rs.getString("remark1"));
                admin.setRemark2(rs.getString("remark2"));
                admin.setRemark3(rs.getString("remark3"));
                vector.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    public Admin AdminLogin(String username, String password) {
        Admin admin = new Admin();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            //3. 创建Sql语句对象
            String sql = "select * from tb_news_admin where username = ? and password = ? ";
            prep = conn.prepareStatement(sql);
            prep.setString(1, username);
            prep.setString(2, password);
            rs = prep.executeQuery();
            if(rs.next()) {
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setRole(rs.getInt("role"));
                admin.setCreateDate(rs.getDate("createDate"));
                admin.setMail(rs.getString("mail"));
                admin.setPhone(rs.getString("phone"));
                admin.setAge(rs.getInt("age"));
                admin.setRemark1(rs.getString("remark1"));
                admin.setRemark2(rs.getString("remark2"));
                admin.setRemark3(rs.getString("remark3"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return admin;
    }

    public int updateAdmin(Admin admin) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "update tb_news_admin set username = ? ,password = ? ,role = ? , createDate = ? ," +
                    "mail = ? , phone = ? , age = ? , remark1 = ? , remark2 = ? , remark3 = ? where id = ? ";
            prep = conn.prepareStatement(sql);
            prep.setString(1,admin.getUsername());
            prep.setString(2,admin.getPassword());
            prep.setInt(3, admin.getRole());
            prep.setDate(4, admin.getCreateDate());
            prep.setString(5, admin.getMail());
            prep.setString(6, admin.getPhone());
            prep.setInt(7, admin.getAge());
            prep.setString(8, admin.getRemark1());
            prep.setString(9, admin.getRemark2());
            prep.setString(10, admin.getRemark3());
            prep.setInt(11, admin.getId());
            flag = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

    public int deleteAdmin(int id) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "delete from tb_news_admin where id = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, id);
            flag = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

    public int insertAdmin(Admin admin) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "insert into tb_news_admin(username,password,role,createDate) values (?,?,?,?)";
            prep = conn.prepareStatement(sql);
            prep.setString(1,admin.getUsername());
            prep.setString(2,admin.getPassword());
            prep.setInt(3, admin.getRole());
            prep.setDate(4, admin.getCreateDate());
            flag = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }
}
