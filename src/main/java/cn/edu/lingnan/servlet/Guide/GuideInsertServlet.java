package cn.edu.lingnan.servlet.Guide;

import cn.edu.lingnan.pojo.Guide;
import cn.edu.lingnan.service.GuideServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;


@WebServlet("/insertGuide")
public class GuideInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Guide guide = new Guide();
        guide.setGuideId(req.getParameter("gid"));
        guide.setGuideName(req.getParameter("gname"));
        guide.setPassword(req.getParameter("password"));
        guide.setSuperuser(Integer.parseInt(req.getParameter("superuser")));
        guide.setFlag(Integer.parseInt(req.getParameter("flag")));
        if ((new GuideServiceMysqlImpl().insertGuide(guide)) == 1) {
            JOptionPane.showMessageDialog(null, "添加成功！");
        } else {
            JOptionPane.showMessageDialog(null, "添加失败，请重试！");
        }
        resp.sendRedirect("/queryAllGuide");

    }
}
