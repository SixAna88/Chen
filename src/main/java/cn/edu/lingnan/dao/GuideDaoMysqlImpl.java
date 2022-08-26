package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Guide;
import cn.edu.lingnan.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GuideDaoMysqlImpl implements GuideDao {

    //查询所有导游信息
    public Vector<Guide> findAllGuide() {
        Vector<Guide> vector = new Vector<Guide>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_guide";
            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();
            while (rs.next()) {
                Guide guide = new Guide();
                guide.setGuideId(rs.getString("gid"));
                guide.setGuideName(rs.getString("gname"));
                guide.setPassword(rs.getString("password"));
                guide.setSuperuser(rs.getInt("superuser"));
                guide.setFlag(rs.getInt("flag"));
                vector.add(guide);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    //根据导游【姓名+密码】查询导游信息
    public Guide findGuideByNameAndPassword(String guideName, String guidePassword) {
        Guide guide = new Guide();//创建接收对象
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        //try里的是局部变量
        try {
            //获取数据库连接  Connection代表数据库
            conn = DBConnection.getInstance().getConnection();
            //3. 创建Sql语句对象
            String sql = "select * from tb_guide where gname = ? and password = ? ";//使用占位符
            prep = conn.prepareStatement(sql);//预编译，不执行sql
            prep.setString(1, guideName);
            prep.setString(2, guidePassword);
            rs = prep.executeQuery();//返回结果集
            if (rs.next()) {//结果唯一，可以使用if
                guide.setGuideId(rs.getString("gid"));
                guide.setGuideName(rs.getString("gname"));
                guide.setPassword(rs.getString("password"));
                guide.setSuperuser(rs.getInt("superuser"));
                guide.setFlag(rs.getInt("flag"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return guide;
    }

    //根据导游【姓名】查找导游信息【模糊查询】
    public Vector<Guide> findGuideByName(String guideName) {
        Vector<Guide> vector = new Vector<Guide>();//集合
        Connection conn = null;
//        Statement stat = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
//            String sql = "select * from tb_guide where gname like '%"+guideName+"%'";
//            stat = conn.createStatement();
//            rs = stat.executeQuery(sql);

            //采用预编译
            String sql = "select * from tb_guide where gname like ?";
            prep = conn.prepareStatement(sql);//预编译，不执行sql
            prep.setString(1, "%" + guideName + "%");
            rs = prep.executeQuery();
            while (rs.next()) {//对象不唯一
                Guide guide = new Guide();
                guide.setGuideId(rs.getString("gid"));
                guide.setGuideName(rs.getString("gname"));
                guide.setPassword(rs.getString("password"));
                guide.setSuperuser(rs.getInt("superuser"));
                guide.setFlag(rs.getInt("flag"));
                vector.add(guide);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            DBConnection.getInstance().closeConnection(conn, stat, rs);
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    //根据导游【编号】查询导游记录【精准查询】
    public Guide findGuideById(String guideId) {
        Guide guide = new Guide();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            //3. 创建Sql语句对象
            String sql = "select * from tb_guide where gid = ? ";
            prep = conn.prepareStatement(sql);
            prep.setString(1, guideId);
            rs = prep.executeQuery();
            if (rs.next()) {//对象唯一，可以用if
                guide.setGuideId(rs.getString("gid"));
                guide.setGuideName(rs.getString("gname"));
                guide.setPassword(rs.getString("password"));
                guide.setSuperuser(rs.getInt("superuser"));
                guide.setFlag(rs.getInt("flag"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return guide;
    }

    //新增操作
    public int insertGuide(Guide guide) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "insert into tb_guide values (?,?,?,?,?)";
            prep = conn.prepareStatement(sql);
            prep.setString(1, guide.getGuideId());
            prep.setString(2, guide.getGuideName());
            prep.setString(3, guide.getPassword());
            prep.setInt(4, guide.getSuperuser());
            prep.setInt(5, guide.getFlag());
            flag = prep.executeUpdate();//受影响行数
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

    //根据导游【编号】删除导游信息
    public boolean deleteGuideByGid(String guideId) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "delete from tb_guide where gid = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, guideId);
            if (prep.executeUpdate() > 0)
                flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

    //修改操作:修改导游信息
    public int updateGuide(Guide guide) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "update tb_guide set gname = ? ,password = ? ,superuser = ?,flag = ? where gid = ? ";
            prep = conn.prepareStatement(sql);
            prep.setString(1, guide.getGuideName());
            prep.setString(2, guide.getPassword());
            prep.setInt(3, guide.getSuperuser());
            prep.setInt(4, guide.getFlag());
            prep.setString(5, guide.getGuideId());
            flag = prep.executeUpdate();//受影响行数, flag= 1
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

    //修改导游信息：修改密码（参数: 导游姓名、新密码）
    public boolean updateGuidePassword(String guideId, String newPassword) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "update tb_guide set password = ? where gid = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, newPassword);
            prep.setString(2, guideId);
            if (prep.executeUpdate() == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

}
