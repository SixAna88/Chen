package cn.edu.lingnan.servlet.Guide;

import cn.edu.lingnan.servlet.HelloServlet;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


//注销账户
@WebServlet("/destroyGuide")
public class GuideDestroyServlet extends HelloServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session =req.getSession();
        session.invalidate();
        System.out.println("[Debug] : 用户已经注销，可以重新登录了");
        resp.sendRedirect("/login.html");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }
}
