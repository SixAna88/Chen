package cn.edu.lingnan.servlet.Guide;

import cn.edu.lingnan.pojo.Guide;
import cn.edu.lingnan.service.GuideServiceMysqlImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateGuide")
public class GuideUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Guide guide = new Guide();
        System.out.println("[Debug]: " + req.getParameter("gid"));
        guide.setGuideId(req.getParameter("gid"));
        guide.setGuideName(req.getParameter("gname"));
        guide.setPassword(req.getParameter("password"));
        guide.setSuperuser(Integer.parseInt(req.getParameter("superuser")));
        guide.setFlag(Integer.parseInt(req.getParameter("flag")));
        System.out.println("[Debug] 待修改学生信息" + guide.toString());
        new GuideServiceMysqlImpl().updateGuide(guide);
        resp.sendRedirect("/queryAllGuide");
    }
}
