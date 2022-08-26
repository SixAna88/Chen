package cn.edu.lingnan.servlet.uitls;

import cn.edu.lingnan.dao.GuideDaoMysqlImpl;
import cn.edu.lingnan.pojo.Guide;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 获取页面传递过来的参数：req
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("[Debug]: username = " + username + ", password = " + password);
        //2. 处理数据，一般来说就是调用相应业务层逻辑
        GuideDaoMysqlImpl guideDaoMysql = new GuideDaoMysqlImpl();
        Guide guide = guideDaoMysql.findGuideByNameAndPassword(username, password);
        String guideName = guide.getGuideName();
        HttpSession session = req.getSession();
        //设置一个键值对
        session.setAttribute("username", username);
        session.setAttribute("superuser", guide.getSuperuser());
        //3. 页面跳转
        if (guideName != null) {
            resp.sendRedirect("/main.jsp");
          /*  Integer role = guide.getSuperuser();
            switch (role) {
                case 1:
//                    resp.sendRedirect("superAdmin.jsp");
                      resp.sendRedirect("/main.jsp");
                    break;
                case 0:
                    resp.sendRedirect("guideManage.jsp");
                    break;
                default:
                    System.out.println("权限不足！");
                    break;
            }*/
        } else
            resp.sendRedirect("/error.html");
    }

}
