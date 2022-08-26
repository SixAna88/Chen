package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Path;
import cn.edu.lingnan.util.DBConnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class PathDaoMysqlImlp implements PathDao {

    //遍历路径信息
    public Vector<Path> queryAllPath() {
        Vector<Path> vector = new Vector<Path>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_path";
            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();
            while (rs.next()) {
                Path path = new Path();
                path.setPathId(rs.getString("pid"));
                path.setPathName(rs.getString("pname"));
                path.setFlag(rs.getInt("flag"));
                vector.add(path);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    //根据路径编号，查询一条路径记录
    public Path selectPathByPid(String pathId) {
        Path path = new Path();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_path where pid = ? ";
            prep = conn.prepareStatement(sql);
            prep.setString(1, pathId);
            rs = prep.executeQuery();

            if(rs.next()) {
                path.setPathId(rs.getString("pid"));
                path.setPathName(rs.getString("pname"));
                path.setFlag(rs.getInt("flag"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return path;
    }

    //根据路径编号，删除一条路径记录
    public boolean deletePathByPid(String pathId) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "delete from tb_path where pid = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, pathId);
            if (prep.executeUpdate() == 1)
                flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

    //修改路径信息
    public int updatePath(Path path) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "update tb_path set pname = ? ,flag = ? where pid = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, path.getPathName());
            prep.setInt(2, path.getFlag());
            prep.setString(3, path.getPathId());
            flag = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

    //新增路径信息
    public int insertPath(Path path) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "insert into tb_path values (?,?,?)";
            prep = conn.prepareStatement(sql);
            prep.setString(1, path.getPathId());
            prep.setString(2, path.getPathName());
            prep.setInt(3, path.getFlag());
            flag = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }


}
