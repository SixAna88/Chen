package cn.edu.lingnan.service;

import cn.edu.lingnan.dao.NewsInfoDao;
import cn.edu.lingnan.dao.NewsInfoDaoImpl;
import cn.edu.lingnan.pojo.newInfo;

import java.util.Vector;

public class NewsInfoServiceImpl implements NewsInfoService {
      NewsInfoDao newsInfoDao = new NewsInfoDaoImpl();
        /**
         * 查询全部新闻信息
         */
        @Override
        public Vector<newInfo> selectAllNewsInfo() {
            return newsInfoDao.selectAllNewsInfo();
        }

        /**
         * 通过查询全部新闻信息
         *
         * @param typeId
         */
        @Override
        public Vector<newInfo> selectAllNewsInfo(int typeId) {
            return newsInfoDao.selectAllNewsInfo(typeId);
        }

    /**
     * 通过新闻编号来查询这个新闻编号的新闻
     *
     * @param newsId
     */
    @Override
    public Vector<newInfo> selectNewsInfo(String newsId) {
        return newsInfoDao.selectNewsInfo(newsId);
    }

    /**
         * 增加新闻信息
         *
         * @param newinfo
         */
        @Override
        public int addNewInfo(newInfo newinfo) {
            return newsInfoDao.addNewInfo(newinfo);
        }

        /**
         * 通过新闻编号删除新闻
         *
         * @param newsId
         */
        @Override
        public int deleteNewInfo(String newsId) {
            return newsInfoDao.deleteNewInfo(newsId);
        }

        /**
         * 通过新闻编号修改新闻信息
         *
         * @param newInfo
         */
        @Override
        public int updateNewInfo(newInfo newInfo) {
            return newsInfoDao.updateNewInfo(newInfo);
        }
}


