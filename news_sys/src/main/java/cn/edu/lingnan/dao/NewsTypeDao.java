package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.newsType;

import java.util.Vector;

public interface NewsTypeDao {
    /**
     * 查询所有文章类型
     */
    Vector<newsType> selectAllNewsType();
    /**
     * 通过新闻类别名查询所有文章类型
     */
    Vector<newsType> selectAllNewsType(String typeName);
    /**
     * 增加文章类型
     */
    public int addNewsType(newsType newstype);
    /**
     * 通过类型编号来删除文章类型
     * */
    public int deleteNewsType(int typeId);
    /**
     * 通过类型编号修改文章类型信息
     * */
    public int updateNewsType(newsType newstype);
    /**
     * 通过类型名来模糊查询新闻类型名
     * */
    Vector<newsType> selectNewsTypeByTypeName(String typeName);
}
