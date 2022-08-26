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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/queryAllPath")
public class PathQueryAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        GuideServiceMysqlImpl guideServiceMysql =new GuideServiceMysqlImpl();
//        Vector<Guide> guides = guideServiceMysql.findAllGuide();

        Vector<Path> paths = new PathServiceMysqlImpl().queryAllPath();
        System.out.println("[debug]: 路线信息一共有: "+ paths.size()+ "条记录");
        HttpSession session = req.getSession();
        session.setAttribute("allPath",paths);
        resp.sendRedirect("/allPath.jsp");
    }
}
