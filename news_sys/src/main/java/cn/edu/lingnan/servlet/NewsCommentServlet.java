package cn.edu.lingnan.servlet;

import cn.edu.lingnan.dao.NewsCommentDaoImpl;
import cn.edu.lingnan.pojo.Users;
import cn.edu.lingnan.pojo.newsComment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Vector;

@WebServlet("*.newsComment")
public class NewsCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        /*获取请求的url地址信息*/
        String url  = req.getRequestURI();

        /*截取其中的方法名*/
        String methodName = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."));
        Method method = null;
        try {
            /*使用反射机制获取在本类中声明的方法*/
            method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            /*执行方法*/
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("调用方法出错！！！");
        }
    }


    //查询所有评论
    protected void allNewsComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Vector<newsComment> allnewsComment = new NewsCommentDaoImpl().selectAllNewsComment();
        req.setAttribute("allComment",allnewsComment);
        req.getRequestDispatcher("allComment.jsp").forward(req,resp);
    }

    //根据评论ID查询评论
    protected void queryNewsComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Vector<newsComment> newsComments = null;
        String commContent = req.getParameter("commContent");
        newsComments = new NewsCommentDaoImpl().selectNewsCommentByContent(commContent);
        req.setAttribute("queryNewsComment",newsComments);
        req.getRequestDispatcher("queryNewsComment.jsp").forward(req,resp);
    }


    //删除评论信息
    protected void deleteNewsComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String comId = req.getParameter("comId");
        String flag = req.getParameter("flag");

        if(flag==null){
            new NewsCommentDaoImpl().deleteNewsComment(Integer.parseInt(comId));
        }
        else{
            String[] split = req.getParameter("comId").split(",");
            for (String i:split) {
                new NewsCommentDaoImpl().deleteNewsComment(Integer.parseInt(i));
            }
        }
        resp.sendRedirect("allNewsComment.newsComment");
    }

    //增加新闻评论
    protected void addNewsComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        newsComment Comment = new newsComment();
        Comment.setNewsId(Integer.parseInt(req.getParameter("newsId1")));
        Comment.setUserId(Integer.parseInt(req.getParameter("userId1")));
        Comment.setCommContent(req.getParameter("Comment1"));
        Comment.setCreateDate(Date.valueOf(req.getParameter("createDate1")));

        if (new NewsCommentDaoImpl().insertNewsComment(Comment)==1) {
            resp.sendRedirect("allNewsComment.newsComment");
        }
    }


    //更新评论
    protected void updateNewsComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*生成用户对象*/
        newsComment Comment=new newsComment();
        /*给用户的属性赋值*/
        Comment.setComId(Integer.parseInt(req.getParameter("comId")));
        Comment.setNewsId(Integer.parseInt(req.getParameter("newsId")));
        Comment.setUserId(Integer.parseInt(req.getParameter("userId")));
        Comment.setCommContent(req.getParameter("commContent"));
        Comment.setCreateDate(Date.valueOf(req.getParameter("createDate")));
        new NewsCommentDaoImpl().updateNewsComment(Comment);
        /*判断是否更新成功*/
        resp.sendRedirect("allNewsComment.newsComment");
    }

    protected void addNewsCommentTwo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        newsComment Comment = new newsComment();
        Comment.setNewsId(Integer.parseInt(req.getParameter("newsId1")));
        Comment.setUserId(Integer.parseInt(req.getParameter("userId1")));
        Comment.setCommContent(req.getParameter("Comment1"));
        Comment.setCreateDate(Date.valueOf(req.getParameter("createDate1")));

        String newsId = req.getParameter("newsId1");
        int id = Integer.parseInt(newsId);
        if (new NewsCommentDaoImpl().insertNewsComment(Comment)==1) {
            resp.sendRedirect("allTitle?action=selectInfo&NewsId="+id);
        }
    }
}
