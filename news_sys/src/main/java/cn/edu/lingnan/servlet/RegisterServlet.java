package cn.edu.lingnan.servlet;

import cn.edu.lingnan.dao.UsersDaoImpl;
import cn.edu.lingnan.pojo.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*解决乱码*/
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        /*获取表单参数*/
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password1 = req.getParameter("password1");

        /*生成用户*/
        Users users = new Users(username, password);
        if (password1.equals(password)) {

            int i = new UsersDaoImpl().UserRegister(username,password);
            if (i == 1) {
                resp.sendRedirect("login.jsp");
            } else {
                resp.sendRedirect("error.jsp");
            }
        }
    }


}
