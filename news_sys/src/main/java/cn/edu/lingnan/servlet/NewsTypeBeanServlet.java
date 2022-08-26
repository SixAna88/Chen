package cn.edu.lingnan.servlet;

import cn.edu.lingnan.dao.NewsTypeDaoImpl;
import cn.edu.lingnan.pojo.newsType;
import cn.edu.lingnan.service.NewsInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.Vector;

@WebServlet("/NewsTypeBean")
public class NewsTypeBeanServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        // 获取请求标记
        String action = req.getParameter("action");
        String returns = null;
        // 对比请求标记值

        // 对比请求标记值
        if(action.equals("all")) {
            // 调用处理方法接受返回值
            this.allType(req, resp);
            resp.sendRedirect("allNewsType.jsp");
        }else if (action.equals("delete")) {
            // 调用处理方法接受返回值
            this.deleteType(req, resp);
            resp.sendRedirect("NewsTypeBean?action=all");
        }else if(action.equals("add")){
            this.addType(req,resp);
            resp.sendRedirect("NewsTypeBean?action=all");
        }else if (action.equals("query")){
            this.queryType(req,resp);
            resp.sendRedirect("queryNewsType.jsp");
        }else if (action.equals("update")){
            this.updateType(req,resp);
            resp.sendRedirect("NewsTypeBean?action=all");
        }
        // 对比请求标记值
    }

    public void allType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Vector<newsType> allNewsType = new NewsTypeDaoImpl().selectAllNewsType();
        HttpSession session = req.getSession();
        session.setAttribute("allNewsType", allNewsType);
    }

        public void deleteType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String TypeId = req.getParameter("TypeId");
        System.out.println("[dug]待删除的旅游团编号" + TypeId);
        String flag = req.getParameter("flag");
        //2.
        if (flag == null) {
            System.out.println("[dug]单个删除的旅游团编号" + TypeId);
            NewsTypeDaoImpl newsTypeDao = new NewsTypeDaoImpl();
            NewsInfoServiceImpl newsInfoService = new NewsInfoServiceImpl();
            System.out.println(newsTypeDao.deleteNewsType(Integer.parseInt(TypeId)));
        } else {
            System.out.println("[dug]批量删除的旅游团编号" + TypeId);
            String[] split = req.getParameter("TypeId").split(",");
            for (String s : split) {
                NewsTypeDaoImpl newsTypeDao = new NewsTypeDaoImpl();
                System.out.println(newsTypeDao.deleteNewsType(Integer.parseInt(s)));
            }
        }

    }
    public void addType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        newsType newsType=new newsType();
        newsType.setTypeName(req.getParameter("typeName"));
        newsType.setCreateDate(Date.valueOf(req.getParameter("createDate")));
        new NewsTypeDaoImpl().addNewsType(newsType);
    }

    public void queryType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Vector newsType=new Vector();
        String typeName=req.getParameter("typename");
        newsType=new NewsTypeDaoImpl().selectNewsTypeByTypeName(typeName);
        System.out.println(newsType);
        HttpSession session = req.getSession();
        session.setAttribute("newsType",newsType );
    }

    public void updateType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*生成管理员对象*/
        newsType newstype=new newsType();
        /*赋值操作*/
        newstype.setTypeId(Integer.parseInt(req.getParameter("typeId")));
        System.out.println(Integer.parseInt(req.getParameter("typeId")));
        newstype.setTypeName(req.getParameter("typeName"));
        newstype.setCreateDate(Date.valueOf(req.getParameter("createDate")));
        new NewsTypeDaoImpl().updateNewsType(newstype);
    }
        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}