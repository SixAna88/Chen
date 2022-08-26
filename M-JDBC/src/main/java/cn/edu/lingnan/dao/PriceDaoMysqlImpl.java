package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Price;
import cn.edu.lingnan.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class PriceDaoMysqlImpl implements PriceDao {

    public Vector<Price> queryAllPrice() {
        Vector<Price> vector = new Vector<Price>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_price";
            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();
            while (rs.next()) {
                Price price = new Price();
                price.setGuideId(rs.getString("gid"));
                price.setPathId(rs.getString("pid"));
                price.setPrice(rs.getInt("price"));
                vector.add(price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return vector;
    }

    public List<Price> selectPriceByGid(String guideId) {
        List<Price> list = new LinkedList<Price>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_price where gid = ? ";
            prep = conn.prepareStatement(sql);
            prep.setString(1, guideId);
            rs = prep.executeQuery();
            while (rs.next()) {
                Price price = new Price();
                price.setGuideId(rs.getString("gid"));
                price.setPathId(rs.getString("pid"));
                price.setPrice(rs.getInt("price"));
                list.add(price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return list;
    }

    public List<Price> selectPriceByPid(String pathId) {
        List<Price> list = new LinkedList<Price>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select * from tb_price where pid = ? ";
            prep = conn.prepareStatement(sql);
            prep.setString(1, pathId);
            rs = prep.executeQuery();
            while (rs.next()) {
                Price price = new Price();
                price.setGuideId(rs.getString("gid"));
                price.setPathId(rs.getString("pid"));
                price.setPrice(rs.getInt("price"));
                list.add(price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return list;
    }

    public int selectPriceNumberByPid(String pathId) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "select count(*) as num from tb_price where pid = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, pathId);
            rs = prep.executeQuery();
            while (rs.next()) {
                flag = Integer.parseInt(rs.getString("num"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, rs);
        }
        return flag;
    }

    public boolean deletePriceByGid(String guideId) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            //3. 创建Sql语句对象
            String sql = "delete from tb_price where gid = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, guideId);
            if (prep.executeUpdate() == 1)
                flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

    public boolean deletePriceByPid(String pathId) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            //3. 创建Sql语句对象
            String sql = "delete from tb_price where pid = ?";
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

    public boolean deletePriceByGidAndPid(String guideId, String pathId) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            //3. 创建Sql语句对象
            String sql = "delete from tb_price where gid = ? and pid = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, guideId);
            prep.setString(2, pathId);
            if (prep.executeUpdate() == 1)
                flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

    public int updatePrice(Price price) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "update tb_price set price = ? where gid = ? and pid = ? ";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, price.getPrice());
            prep.setString(2, price.getGuideId());
            prep.setString(3, price.getPathId());
            flag = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }

    public int insertPrice(Price price) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "insert into tb_price values (?,?,?)";
            prep = conn.prepareStatement(sql);
            prep.setString(1, price.getGuideId());
            prep.setString(2, price.getPathId());
            prep.setInt(3, price.getPrice());
            flag = prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().closeConnection(conn, prep, null);
        }
        return flag;
    }
}
