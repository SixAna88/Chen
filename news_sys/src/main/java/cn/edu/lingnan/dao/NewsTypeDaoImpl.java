package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Admin;
import cn.edu.lingnan.pojo.newsType;
import cn.edu.lingnan.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class NewsTypeDaoImpl implements NewsTypeDao {
    /**
     * 查询所有文章类型
     */
    @Override
    public Vector<newsType> selectAllNewsType() {
        Vector<newsType> vector = new Vector<newsType>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            //1.jdbc连接数据库，加载驱动程序
            conn = DBConnection.getInstance().getConnection();
            //2.获取连接
            String sql = "select * from tb_newstype";
            //3.在连接的基础上执行sql
            prep = conn.prepareStatement(sql);
            //4.处理结果
            rs = prep.executeQuery();
            while (rs.next()) {
                newsType newsType=new newsType();
                newsType.setTypeId(rs.getInt("typeId"));
                newsType.setTypeName(rs.getString("typeName"));
                newsType.setCreateDate(rs.getDate("createDate"));
                vector.add(newsType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        //5.管理资源
        return vector;
    }

    /**
     * 通过新闻类别名查询所有文章类型
     *
     * @param typeName
     */
    @Override
    public Vector<newsType> selectAllNewsType(String typeName) {
        Vector<newsType> vector = new Vector<newsType>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            //1.jdbc连接数据库，加载驱动程序
            conn = DBConnection.getInstance().getConnection();
            //2.获取连接
            String sql = "select * from tb_newstype where typeName=?";
            //3.在连接的基础上执行sql
            prep = conn.prepareStatement(sql);
            prep.setString(1,typeName);
            System.out.println(typeName);
            //4.处理结果
            rs = prep.executeQuery();
            while (rs.next()) {
                newsType newsType=new newsType();
                newsType.setTypeId(rs.getInt("typeId"));
                newsType.setTypeName(rs.getString("typeName"));
                newsType.setCreateDate(rs.getDate("createDate"));
                vector.add(newsType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        //5.管理资源
        return vector;
    }

    /**
     * 增加文章类型
     *
     * @param newstype
     */
    @Override
    public int addNewsType(newsType newstype) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep= null;
        try {
            //1.jdbc连接数据库，加载驱动程序
            conn = DBConnection.getInstance().getConnection();
            //2.获取连接
            String sql = "insert into tb_newstype(typeName,createDate) values (?,?)";
            //3.在连接的基础上执行sql
            prep = conn.prepareStatement(sql);
            prep.setString(1,newstype.getTypeName());
            prep.setDate(2,newstype.getCreateDate());
            //4.处理结果
            flag=prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn,prep,null);
        }
        //5.管理资源
        return flag;
    }

    /**
     * 通过类型编号来删除文章类型
     *
     * @param typeId
     */
    @Override
    public int deleteNewsType(int typeId) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep= null;
        try {
            //1.jdbc连接数据库，加载驱动程序
            conn = DBConnection.getInstance().getConnection();
            //2.获取连接
            String sql = "delete from tb_newstype where typeId=?";
            //3.在连接的基础上执行sql
            prep = conn.prepareStatement(sql);
            prep.setInt(1,typeId);
            //4.处理结果
            flag=prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn,prep,null);
        }
        //5.管理资源
        return flag;
    }

    /**
     * 通过类型编号修改文章类型信息
     *
     * @param newstype
     */
    @Override
    public int updateNewsType(newsType newstype) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep= null;
        try {
            //1.jdbc连接数据库，加载驱动程序
            conn = DBConnection.getInstance().getConnection();
            //2.获取连接
            String sql = "update tb_newstype set typeName=?,createDate=? where typeId=?";
            //3.在连接的基础上执行sql
            prep = conn.prepareStatement(sql);
            prep.setString(1,newstype.getTypeName());
            prep.setDate(2,newstype.getCreateDate());
            prep.setInt(3,newstype.getTypeId());
            //4.处理结果
            flag=prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn,prep,null);
        }
        //5.管理资源
        return flag;
    }

    /**
     * 通过类型名来模糊查询新闻类型名
     *
     * @param typeName
     */
    @Override
    public Vector<newsType> selectNewsTypeByTypeName(String typeName) {
        Vector<newsType> vector = new Vector<newsType>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_newstype where typeName like ?";
            prep = conn.prepareStatement(sql);//预编译，不执行sql
            prep.setString(1, "%" + typeName + "%");
            rs = prep.executeQuery();
            while (rs.next()) {
                newsType newstype=new newsType();
                newstype.setTypeId(rs.getInt("typeId"));
                newstype.setTypeName(rs.getString("typeName"));
                newstype.setCreateDate(rs.getDate("createDate"));
                vector.add(newstype);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

}
