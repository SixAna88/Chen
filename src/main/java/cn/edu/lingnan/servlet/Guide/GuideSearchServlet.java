package cn.edu.lingnan.servlet.Guide;

import cn.edu.lingnan.pojo.Guide;
import cn.edu.lingnan.service.GuideServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

@WebServlet("/search")
public class GuideSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        GuideServiceMysqlImpl guideServiceMysql =new GuideServiceMysqlImpl();
//        Vector<Guide> guides = guideServiceMysql.findAllGuide();

        Vector<Guide> guides = new GuideServiceMysqlImpl().findGuideByName(req.getParameter("name"));//匿名对象
        HttpSession session = req.getSession();
        session.setAttribute("guide",guides);
        resp.sendRedirect("searchGuide.jsp");
    }
}
