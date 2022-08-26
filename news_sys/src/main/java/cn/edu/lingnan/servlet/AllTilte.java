package cn.edu.lingnan.servlet;

import cn.edu.lingnan.dao.NewsCommentDaoImpl;
import cn.edu.lingnan.dao.NewsTypeDaoImpl;
import cn.edu.lingnan.pojo.newInfo;
import cn.edu.lingnan.pojo.newsComment;
import cn.edu.lingnan.pojo.newsType;
import cn.edu.lingnan.service.NewsInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/allTitle")
public class AllTilte extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        // 获取请求标记
        String action = req.getParameter("action");
        String returns = null;
        // 对比请求标记值

        // 对比请求标记值
        if(action.equals("selectType")) {
            // 调用处理方法接受返回值
            this.selectType(req, resp);
//            resp.sendRedirect("allNewsInfo.jsp");
        }else if (action.equals("selectInfo")) {
            // 调用处理方法接受返回值
            this.selectInfo(req, resp);
//            resp.sendRedirect("NewsInfoBean?action=all");
        }
    }
    public void selectType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int typeId=Integer.parseInt(req.getParameter("typeId"));
        Vector<newInfo> allNewInfo = new NewsInfoServiceImpl().selectAllNewsInfo(typeId);
        req.setAttribute("allNewInfo",allNewInfo);
        Vector<newsType> allnewsTypes=new NewsTypeDaoImpl().selectAllNewsType();
        req.setAttribute("allnewsTypes",allnewsTypes);
        req.getRequestDispatcher("users(1).jsp").forward(req,resp);
    }
    public void selectInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String NewsId =req.getParameter("NewsId");
        Vector<newInfo> allNewInfo = new NewsInfoServiceImpl().selectNewsInfo(NewsId);
        req.setAttribute("allNewInfo",allNewInfo);
        Vector<newsComment> allComment=new NewsCommentDaoImpl().selectNewsCommentByNewsId(Integer.parseInt(NewsId));
        req.setAttribute("AllComment",allComment);
        req.getRequestDispatcher("usersNews.jsp").forward(req,resp);
    }
}
