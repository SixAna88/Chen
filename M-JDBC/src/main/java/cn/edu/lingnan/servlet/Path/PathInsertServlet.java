package cn.edu.lingnan.servlet.Path;

import cn.edu.lingnan.pojo.Guide;
import cn.edu.lingnan.pojo.Path;
import cn.edu.lingnan.service.GuideServiceMysqlImpl;
import cn.edu.lingnan.service.PathServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;


@WebServlet("/insertPath")
public class PathInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path = new Path();
        path.setPathId(req.getParameter("pid"));
        path.setPathName(req.getParameter("pname"));
        path.setFlag(Integer.parseInt(req.getParameter("flag")));
        if ((new PathServiceMysqlImpl().insertPath(path)== 1)){
            JOptionPane.showMessageDialog(null, "添加成功！");
        } else {
            JOptionPane.showMessageDialog(null, "添加失败，请重试！");
        }
        resp.sendRedirect("/queryAllPath");
    }
}
