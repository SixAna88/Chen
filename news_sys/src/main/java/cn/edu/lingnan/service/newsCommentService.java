package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.newsComment;

import java.util.Vector;

public interface newsCommentService {
    /*查询所有新闻评论*/
    Vector<newsComment> selectAllNewsComment();

    /*根据评论编号查询新闻评论*/
    newsComment selectNewsCommentByComId(int comId);

    /*根据信息编号查询新闻评论*/
    Vector<newsComment> selectNewsCommentByNewsId(int newsId);

    /*根据用户编号查询新闻评论*/
    Vector<newsComment> selectNewsCommentByUserId(int userId);

    /*根据评论关键字查询新闻评论信息*/
    Vector<newsComment> selectNewsCommentByContent(String content);

    /*修改新闻信息*/
    int updateNewsComment(newsComment newsComment);

    /*删除新闻信息*/
    int deleteNewsComment(int comId);

    /*新增新闻信息*/
    int insertNewsComment(newsComment newsComment);
}
