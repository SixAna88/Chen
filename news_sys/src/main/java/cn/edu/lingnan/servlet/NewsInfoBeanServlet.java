package cn.edu.lingnan.servlet;

import cn.edu.lingnan.dao.NewsInfoDaoImpl;
import cn.edu.lingnan.dao.NewsTypeDaoImpl;
import cn.edu.lingnan.pojo.newInfo;
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

@WebServlet("/NewsInfoBean")
public class NewsInfoBeanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
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
        if(action.equals("all")) {
            // 调用处理方法接受返回值
            this.allType(req, resp);
            resp.sendRedirect("allNewsInfo.jsp");
        }else if (action.equals("delete")) {
            // 调用处理方法接受返回值
            this.deleteType(req, resp);
            resp.sendRedirect("NewsInfoBean?action=all");
        }else if(action.equals("add")){
            this.addType(req,resp);
            resp.sendRedirect("NewsInfoBean?action=all");
        }else if (action.equals("query")){
            this.queryType(req,resp);
            resp.sendRedirect("queryNewsInfo.jsp");
        }else if (action.equals("update")){
            this.updateType(req,resp);
            resp.sendRedirect("NewsInfoBean?action=all");
        }
    }
    public void allType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Vector<newInfo> allNewInfo = new NewsInfoServiceImpl().selectAllNewsInfo();
        HttpSession session = req.getSession();
        session.setAttribute("allNewInfo", allNewInfo);
    }

    public void deleteType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String NewsId =req.getParameter("NewsId");
        System.out.println("[dug]待删除的旅游团编号" + NewsId);
        String flag = req.getParameter("flag");
        //2.
        if(flag==null) {
            System.out.println("[dug]单个删除的旅游团编号" + NewsId);
            NewsInfoServiceImpl newsInfoService=new NewsInfoServiceImpl();
            System.out.println(newsInfoService.deleteNewInfo(NewsId));
        }else {
            System.out.println("[dug]批量删除的旅游团编号" + NewsId);
            String[] split=req.getParameter("NewsId").split(",");
            for (String s : split) {
                System.out.println(new NewsInfoServiceImpl().deleteNewInfo(s));
            }
        }

    }
    public void addType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*生成管理员对象*/
        newInfo newinfo =new newInfo();
        /*赋值操作*/
        newinfo.setNewsId(req.getParameter("newsId"));
        newinfo.setNewsTitle(req.getParameter("newsTitle"));
        newinfo.setNewsContent(req.getParameter("newsContent"));
        newinfo.setTypeId(Integer.parseInt(req.getParameter("typeId")));
        newinfo.setNewsPublish(Date.valueOf(req.getParameter("newsPublish")));
        newinfo.setNewsSource(req.getParameter("newsSource"));
        newinfo.setRemark(req.getParameter("remark"));
        new NewsInfoDaoImpl().addNewInfo(newinfo);
    }

    public void queryType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Vector<newInfo> newInfos=new Vector<newInfo>();
        String newstitle = req.getParameter("newstitle");
        String newscontent = req.getParameter("newscontent");

        if (newstitle != "") {
            if (newscontent != "") {
                newInfos=new NewsInfoDaoImpl().selectNewsInfoByNewsTiltleAndNewsContent(newstitle,newscontent);
            } else {
                newInfos=new NewsInfoDaoImpl().selectNewsInfoByNewsTiltle(newstitle);
            }
        } else if (newscontent!= "") {
            newInfos=new NewsInfoDaoImpl().selectNewsInfoByNewsContent(newscontent);
        } else {
            newInfos=new NewsInfoDaoImpl().selectAllNewsInfo();
        }
        HttpSession session = req.getSession();
        session.setAttribute("newInfos", newInfos);
    }

    public void updateType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*生成管理员对象*/
        newInfo newinfo =new newInfo();
        /*赋值操作*/
        newinfo.setNewsId(req.getParameter("newsId"));
        newinfo.setNewsTitle(req.getParameter("newsTitle"));
        newinfo.setNewsContent(req.getParameter("newsContent"));
        newinfo.setTypeId(Integer.parseInt(req.getParameter("typeId")));
        newinfo.setNewsPublish(Date.valueOf(req.getParameter("newsPublish")));
        newinfo.setNewsSource(req.getParameter("newsSource"));
        newinfo.setRemark(req.getParameter("remark"));
        new NewsInfoDaoImpl().updateNewInfo(newinfo);
    }
}
