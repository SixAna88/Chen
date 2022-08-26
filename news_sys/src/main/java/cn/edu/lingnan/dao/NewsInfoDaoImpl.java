package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.newInfo;
import cn.edu.lingnan.pojo.newsType;
import cn.edu.lingnan.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class NewsInfoDaoImpl implements NewsInfoDao{
    /**
     * 查询全部新闻信息
     * */
    @Override
    public Vector<newInfo> selectAllNewsInfo() {
        Vector<newInfo> vector = new Vector<newInfo>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            //1.jdbc连接数据库，加载驱动程序
            conn = DBConnection.getInstance().getConnection();
            //2.获取连接
            String sql = "select * from tb_newsinfo";
            //3.在连接的基础上执行sql
            prep = conn.prepareStatement(sql);
            //4.处理结果
            rs = prep.executeQuery();
            while (rs.next()) {
                newInfo newinfo=new newInfo();
                newinfo.setNewsId(rs.getString("newsId"));
                newinfo.setNewsTitle(rs.getString("newsTitle"));
                newinfo.setNewsContent(rs.getString("newsContent"));
                newinfo.setTypeId(rs.getInt("typeId"));
                newinfo.setNewsPublish(rs.getDate("newsPublish"));
                newinfo.setNewsSource(rs.getString("newsSource"));
                newinfo.setRemark(rs.getString("remark"));
                vector.add(newinfo);
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
     * 通过查询全部新闻信息
     * */
    @Override
    public Vector<newInfo> selectAllNewsInfo(int typeId) {
        Vector<newInfo> vector = new Vector<newInfo>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            //1.jdbc连接数据库，加载驱动程序
            conn = DBConnection.getInstance().getConnection();
            //2.获取连接
            String sql = "select * from tb_newsinfo where typeId=?";
            //3.在连接的基础上执行sql
            prep = conn.prepareStatement(sql);
            prep.setInt(1,typeId);
            //4.处理结果
            rs = prep.executeQuery();
            while (rs.next()) {
                newInfo newinfo=new newInfo();
                newinfo.setNewsId(rs.getString("newsId"));
                newinfo.setNewsTitle(rs.getString("newsTitle"));
                newinfo.setNewsContent(rs.getString("newsContent"));
                newinfo.setTypeId(rs.getInt("typeId"));
                newinfo.setNewsPublish(rs.getDate("newsPublish"));
                newinfo.setNewsSource(rs.getString("newsSource"));
                newinfo.setRemark(rs.getString("remark"));
                vector.add(newinfo);
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
     * 通过新闻编号来查询这个新闻编号的新闻
     *
     * @param newsId
     */
    @Override
    public Vector<newInfo> selectNewsInfo(String newsId) {
        Vector<newInfo> vector = new Vector<newInfo>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            //1.jdbc连接数据库，加载驱动程序
            conn = DBConnection.getInstance().getConnection();
            //2.获取连接
            String sql = "select * from tb_newsinfo where newsId=?";
            //3.在连接的基础上执行sql
            prep = conn.prepareStatement(sql);
            prep.setString(1,newsId);
            //4.处理结果
            rs = prep.executeQuery();
            while (rs.next()) {
                newInfo newinfo=new newInfo();
                newinfo.setNewsId(rs.getString("newsId"));
                newinfo.setNewsTitle(rs.getString("newsTitle"));
                newinfo.setNewsContent(rs.getString("newsContent"));
                newinfo.setTypeId(rs.getInt("typeId"));
                newinfo.setNewsPublish(rs.getDate("newsPublish"));
                newinfo.setNewsSource(rs.getString("newsSource"));
                newinfo.setRemark(rs.getString("remark"));
                vector.add(newinfo);
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
     * 通过标题来模糊查询文章
     *
     * @param newsTitle
     */
    @Override
    public Vector<newInfo> selectNewsInfoByNewsTiltle(String newsTitle) {
        Vector<newInfo> vector = new Vector<newInfo>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_newsinfo where newsTitle like ?";
            prep = conn.prepareStatement(sql);//预编译，不执行sql
            prep.setString(1, "%" + newsTitle + "%");
            rs = prep.executeQuery();
            while (rs.next()) {
                newInfo newinfo=new newInfo();
                newinfo.setNewsId(rs.getString("newsId"));
                newinfo.setNewsTitle(rs.getString("newsTitle"));
                newinfo.setNewsContent(rs.getString("newsContent"));
                newinfo.setTypeId(rs.getInt("typeId"));
                newinfo.setNewsPublish(rs.getDate("newsPublish"));
                newinfo.setNewsSource(rs.getString("newsSource"));
                newinfo.setRemark(rs.getString("remark"));
                vector.add(newinfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    /**
     * 通过内容来模糊查询文章
     *
     * @param newsContent
     */
    @Override
    public Vector<newInfo> selectNewsInfoByNewsContent(String newsContent) {
        Vector<newInfo> vector = new Vector<newInfo>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_newsinfo where newsContent like ?";
            prep = conn.prepareStatement(sql);//预编译，不执行sql
            prep.setString(1, "%" + newsContent + "%");
            rs = prep.executeQuery();
            while (rs.next()) {
                newInfo newinfo=new newInfo();
                newinfo.setNewsId(rs.getString("newsId"));
                newinfo.setNewsTitle(rs.getString("newsTitle"));
                newinfo.setNewsContent(rs.getString("newsContent"));
                newinfo.setTypeId(rs.getInt("typeId"));
                newinfo.setNewsPublish(rs.getDate("newsPublish"));
                newinfo.setNewsSource(rs.getString("newsSource"));
                newinfo.setRemark(rs.getString("remark"));
                vector.add(newinfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    /**
     * 通过标题和内容来模糊查询文章
     *
     * @param newsContent
     */
    @Override
    public Vector<newInfo> selectNewsInfoByNewsTiltleAndNewsContent(String newsTitle,String newsContent) {
        Vector<newInfo> vector = new Vector<newInfo>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_newsinfo where newsTitle like ? and newsContent like ?";
            prep = conn.prepareStatement(sql);//预编译，不执行sql
            prep.setString(1, "%" + newsTitle + "%");
            prep.setString(2, "%" + newsContent + "%");
            rs = prep.executeQuery();
            while (rs.next()) {
                newInfo newinfo=new newInfo();
                newinfo.setNewsId(rs.getString("newsId"));
                newinfo.setNewsTitle(rs.getString("newsTitle"));
                newinfo.setNewsContent(rs.getString("newsContent"));
                newinfo.setTypeId(rs.getInt("typeId"));
                newinfo.setNewsPublish(rs.getDate("newsPublish"));
                newinfo.setNewsSource(rs.getString("newsSource"));
                newinfo.setRemark(rs.getString("remark"));
                vector.add(newinfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    /**
     * 增加新闻信息
     *
     * @param newinfo
     */
    @Override
    public int addNewInfo(newInfo newinfo) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep= null;
        try {
            //1.jdbc连接数据库，加载驱动程序
            conn = DBConnection.getInstance().getConnection();
            //2.获取连接
            String sql = "insert into tb_newsinfo values (?,?,?,?,?,?,?)";
            //3.在连接的基础上执行sql
            prep = conn.prepareStatement(sql);
            prep.setString(1,newinfo.getNewsId());
            prep.setString(2,newinfo.getNewsTitle());
            prep.setString(3,newinfo.getNewsContent());
            prep.setInt(4,newinfo.getTypeId());
            prep.setDate(5,newinfo.getNewsPublish());
            prep.setString(6,newinfo.getNewsSource());
            prep.setString(7,newinfo.getRemark());
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
     * 通过新闻编号删除新闻
     *
     * @param newsId
     */
    @Override
    public int deleteNewInfo(String newsId) {
        int flag=0;
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            //1.jdbc连接数据库，加载驱动程序
            conn = DBConnection.getInstance().getConnection();
            //2.获取连接
            String sql = "delete from tb_newsinfo where newsId=? ";
            //3.在连接的基础上执行sql
            prep = conn.prepareStatement(sql);
            prep.setString(1,newsId);
            //4.处理结果
            flag=prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        //5.管理资源
        return flag;
    }

    /**
     * 通过新闻编号修改新闻信息
     *
     * @param newInfo
     */
    @Override
    public int updateNewInfo(newInfo newInfo) {
        int flag=0;
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            //1.jdbc连接数据库，加载驱动程序
            conn = DBConnection.getInstance().getConnection();
            //2.获取连接
            String sql = "update tb_newsinfo set newsTitle=?,newsContent=?,typeId=?,newsPublish=?, " +
                    "newsSource=?,remark=? where newsId=? ";
            //3.在连接的基础上执行sql
            prep = conn.prepareStatement(sql);
            prep.setString(1,newInfo.getNewsTitle());
            prep.setString(2,newInfo.getNewsContent());
            prep.setInt(3,newInfo.getTypeId());
            prep.setDate(4,newInfo.getNewsPublish());
            prep.setString(5,newInfo.getNewsSource());
            prep.setString(6,newInfo.getRemark());
            prep.setString(7,newInfo.getNewsId());
            //4.处理结果
            flag=prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        //5.管理资源
        return flag;
    }
}
