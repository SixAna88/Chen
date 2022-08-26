package cn.edu.lingnan.service;

import cn.edu.lingnan.dao.NewsCommentDao;
import cn.edu.lingnan.dao.NewsCommentDaoImpl;
import cn.edu.lingnan.pojo.newsComment;

import java.util.Vector;

public class newsCommentServiceImpl implements newsCommentService{

    NewsCommentDao newsCommentDao = new NewsCommentDaoImpl();

    @Override
    public Vector<newsComment> selectAllNewsComment() {
        return newsCommentDao.selectAllNewsComment();
    }

    @Override
    public newsComment selectNewsCommentByComId(int comId) {
        return newsCommentDao.selectNewsCommentByComId(comId);
    }

    @Override
    public Vector<newsComment> selectNewsCommentByNewsId(int newsId) {
        return newsCommentDao.selectNewsCommentByNewsId(newsId);
    }

    @Override
    public Vector<newsComment> selectNewsCommentByUserId(int userId) {
        return newsCommentDao.selectNewsCommentByUserId(userId);
    }

    @Override
    public Vector<newsComment> selectNewsCommentByContent(String content) {
        return selectNewsCommentByContent(content);
    }

    @Override
    public int updateNewsComment(newsComment newsComment) {
        return newsCommentDao.updateNewsComment(newsComment);
    }

    @Override
    public int deleteNewsComment(int comId) {
        return newsCommentDao.deleteNewsComment(comId);
    }

    @Override
    public int insertNewsComment(newsComment newsComment) {
        return newsCommentDao.insertNewsComment(newsComment);
    }
}
