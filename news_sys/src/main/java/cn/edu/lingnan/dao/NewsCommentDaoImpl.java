package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.*;
import cn.edu.lingnan.pojo.newsComment;
import cn.edu.lingnan.pojo.newsComment;
import cn.edu.lingnan.pojo.newsComment;
import cn.edu.lingnan.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class NewsCommentDaoImpl implements NewsCommentDao {
    @Override
    public Vector<newsComment> selectAllNewsComment() {
        Vector<newsComment> vector = new Vector<newsComment>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_news_comment";
            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();
            while (rs.next()) {
                newsComment newsComment = new newsComment();
                newsComment.setComId(rs.getInt("comId"));
                newsComment.setNewsId(rs.getInt("newsId"));
                newsComment.setUserId(rs.getInt("userId"));
                newsComment.setCommContent(rs.getString("commContent"));
                newsComment.setCreateDate(rs.getDate("createDate"));
                vector.add(newsComment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    @Override
    public newsComment selectNewsCommentByComId(int comId) {
        newsComment newsComment = new newsComment();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            //3. 创建Sql语句对象
            String sql = "select * from tb_news_comment where comId = ? ";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, comId);
            rs = prep.executeQuery();
            if (rs.next()) {//对象唯一，可以用if
                newsComment.setComId(rs.getInt("comId"));
                newsComment.setNewsId(rs.getInt("newsId"));
                newsComment.setUserId(rs.getInt("userId"));
                newsComment.setCommContent(rs.getString("commContent"));
                newsComment.setCreateDate(rs.getDate("createDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return newsComment;
    }

    @Override
    public Vector<newsComment> selectNewsCommentByNewsId(int newsId) {
        Vector<newsComment> vector = new Vector<newsComment>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_news_comment where newsId = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, newsId);
            rs = prep.executeQuery();
            while (rs.next()) {
                newsComment newsComment = new newsComment();
                newsComment.setComId(rs.getInt("comId"));
                newsComment.setNewsId(rs.getInt("newsId"));
                newsComment.setUserId(rs.getInt("userId"));
                newsComment.setCommContent(rs.getString("commContent"));
                newsComment.setCreateDate(rs.getDate("createDate"));
                vector.add(newsComment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    @Override
    public Vector<newsComment> selectNewsCommentByUserId(int userId) {
        Vector<newsComment> vector = new Vector<newsComment>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_news_comment where userId = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, userId);
            rs = prep.executeQuery();
            while (rs.next()) {
                newsComment newsComment = new newsComment();
                newsComment.setComId(rs.getInt("comId"));
                newsComment.setNewsId(rs.getInt("newsId"));
                newsComment.setUserId(rs.getInt("userId"));
                newsComment.setCommContent(rs.getString("commContent"));
                newsComment.setCreateDate(rs.getDate("createDate"));
                vector.add(newsComment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    @Override
    public Vector<newsComment> selectNewsCommentByContent(String content) {
        Vector<newsComment> vector = new Vector<newsComment>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_news_comment where commContent like ?";
            prep = conn.prepareStatement(sql);//预编译，不执行sql
            prep.setString(1, "%" + content + "%");
            rs = prep.executeQuery();
            while (rs.next()) {
               newsComment newsComment = new newsComment();
               newsComment.setComId(rs.getInt("comId"));
               newsComment.setNewsId(rs.getInt("newsId"));
               newsComment.setUserId(rs.getInt("userId"));
               newsComment.setCommContent(rs.getString("commContent"));
               newsComment.setCreateDate(rs.getDate("createDate"));
               vector.add(newsComment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    @Override
    public int updateNewsComment(newsComment newsComment){
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "update tb_news_comment set newsId = ?, userId = ?, commContent = ?, createDate = ? where comId = ? ";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, newsComment.getNewsId());
            prep.setInt(2,newsComment.getUserId());
            prep.setString(3, newsComment.getCommContent());
            prep.setDate(4, newsComment.getCreateDate());
            prep.setInt(5, newsComment.getComId());
            flag = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

    @Override
    public int deleteNewsComment(int comId) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "delete from tb_news_comment where comId = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, comId);
            flag = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

    @Override
    public int insertNewsComment(newsComment newsComment) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "insert into tb_news_comment(newsId,userId,commContent,createDate) values (?,?,?,?)";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, newsComment.getNewsId());
            prep.setInt(2,newsComment.getUserId());
            prep.setString(3,newsComment.getCommContent());
            prep.setDate(4, newsComment.getCreateDate());
            flag = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }
}
