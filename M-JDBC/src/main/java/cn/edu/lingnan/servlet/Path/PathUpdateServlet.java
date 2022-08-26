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
import java.io.IOException;

@WebServlet("/updatePath")
public class PathUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path = new Path();
        path.setPathId(req.getParameter("pid"));
        path.setPathName(req.getParameter("pname"));
        path.setFlag(Integer.parseInt(req.getParameter("flag")));
        new PathServiceMysqlImpl().updatePath(path);
        resp.sendRedirect("/queryAllPath");
    }
}
