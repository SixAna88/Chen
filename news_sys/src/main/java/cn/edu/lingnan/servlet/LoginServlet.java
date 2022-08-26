package cn.edu.lingnan.servlet;

import cn.edu.lingnan.dao.AdminDaoImpl;
import cn.edu.lingnan.dao.UsersDaoImpl;
import cn.edu.lingnan.pojo.Admin;
import cn.edu.lingnan.pojo.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取页面传递过来的参数：req

        /*解决乱码问题*/
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");

        /*获取表单参数*/
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        int id = 0;

        /*角色判断*/
        if (role.equals("管理员")) {
            //2. 处理数据，一般来说就是调用相应业务层逻辑
            Admin admin = new AdminDaoImpl().AdminLogin(username, password);

            //3. 页面跳转
            if (admin.getId() != null) {
                id  = admin.getId();

                /*角色区分*/
                int AdminRole = admin.getRole();
                System.out.println(AdminRole);
                if (AdminRole == 0) {

                    resp.sendRedirect("index.jsp");//超级管理员
                }
                if (AdminRole == 1) {
                    resp.sendRedirect("main.jsp");//二级管理员
                }
            } else {
                resp.sendRedirect("error.jsp");
            }
        } else if (role.equals("用户")) {//普通用户登录
            Users users = new UsersDaoImpl().UsersLogin(username, password);
            if (users.getUserId() != null) {
                id = users.getUserId();
               /* resp.sendRedirect("users(1).jsp");*/
                resp.sendRedirect("allTitle?action=selectType&typeId=1");
            } else {
                resp.sendRedirect("visitor.jsp");
            }
        }

        /*用于${username} 取值*/
        HttpSession session = req.getSession();
        session.setAttribute("id",id);
        session.setAttribute("username", username);
    }
}

