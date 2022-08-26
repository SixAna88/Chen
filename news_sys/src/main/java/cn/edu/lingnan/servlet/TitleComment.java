package cn.edu.lingnan.servlet;

import cn.edu.lingnan.dao.NewsCommentDaoImpl;
import cn.edu.lingnan.dao.UsersDaoImpl;
import cn.edu.lingnan.pojo.Users;
import cn.edu.lingnan.pojo.newsComment;
//import cn.edu.lingnan.service.NewsCommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.Vector;

@WebServlet("/TitleAddComment")
public class TitleComment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        // 获取请求标记
        String userName = req.getParameter("userName");
        System.out.println(userName);
        String newsId=req.getParameter("newsId");
        Users users1=new Users();
        Vector<Users> users=(Vector<Users>)new UsersDaoImpl().selectUsersByName("userName");
        Iterator<Users> iterator2 = users.iterator();
        while (iterator2.hasNext()){
            users1=iterator2.next();
            newsComment Comment = new newsComment();
//        Comment.setComId(Integer.parseInt(req.getParameter("comId1")));
            Comment.setNewsId(Integer.parseInt(newsId));
            Comment.setUserId(users1.getUserId());
            System.out.println(users1.getUserId());
            Comment.setCommContent(req.getParameter("Comment1"));
            Comment.setCreateDate(Date.valueOf("2022-07-7"));
            new NewsCommentDaoImpl().insertNewsComment(Comment);
            resp.sendRedirect("allNewsInfo2?typeId=1");
        }
//        newsComment Comment = new newsComment();
////        Comment.setComId(Integer.parseInt(req.getParameter("comId1")));
//        Comment.setNewsId(Integer.parseInt(newsId));
//        Comment.setUserId(users1.getUserId());
//        System.out.println(users1.getUserId());
//        Comment.setCommContent(req.getParameter("Comment1"));
//        Comment.setCreateDate(Date.valueOf("2022-07-7"));
//        new NewsCommentDaoImpl().insertNewsComment(Comment);
//        resp.sendRedirect("allNewsInfo2?typeId=1");
//        if (new NewsCommentServiceImpl().insertNewsCommentByComId(Comment)==1) {
//            resp.sendRedirect("/allComment");
//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
