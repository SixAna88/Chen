package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.newInfo;

import java.util.Vector;

public interface NewsInfoDao {
    /**
     * 查询全部新闻信息
     * */
    Vector<newInfo> selectAllNewsInfo();
    /**
     * 通过查询全部新闻信息
     * */
    Vector<newInfo> selectAllNewsInfo(int typeId);
    /**
     * 通过新闻编号来查询这个新闻编号的新闻
     * */
    Vector<newInfo> selectNewsInfo(String newsId);
    /**
     * 通过标题来模糊查询文章
     * */
    Vector<newInfo> selectNewsInfoByNewsTiltle(String newsTitle);
    /**
     * 通过内容来模糊查询文章
     * */
    Vector<newInfo> selectNewsInfoByNewsContent(String newsContent);
    /**
     * 通过标题和内容来模糊查询文章
     * */
    Vector<newInfo> selectNewsInfoByNewsTiltleAndNewsContent(String newsTitle,String newsContent);
    /**
     * 增加新闻信息
     * */
    public int addNewInfo(newInfo newinfo);
    /**
     * 通过新闻编号删除新闻
     * */
    public int deleteNewInfo(String newsId);
    /**
     * 通过新闻编号修改新闻信息
     * */
    public int updateNewInfo(newInfo newInfo);

}
