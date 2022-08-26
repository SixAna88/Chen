package cn.edu.lingnan.servlet.Guide;

import cn.edu.lingnan.pojo.Guide;
import cn.edu.lingnan.service.GuideServiceMysqlImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/queryAllGuide")
public class GuideQueryAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        GuideServiceMysqlImpl guideServiceMysql =new GuideServiceMysqlImpl();
//        Vector<Guide> guides = guideServiceMysql.findAllGuide();

        Vector<Guide> allGuide = new GuideServiceMysqlImpl().findAllGuide();//匿名对象
        System.out.println("[debug]: 学生信息一共有: "+ allGuide.size()+ "条记录");
        HttpSession session = req.getSession();
        session.setAttribute("allGuide",allGuide);
        resp.sendRedirect("/allGuide.jsp");
    }
}
