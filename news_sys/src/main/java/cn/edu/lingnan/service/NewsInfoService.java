package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.newInfo;

import java.util.Vector;

public interface NewsInfoService {
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
