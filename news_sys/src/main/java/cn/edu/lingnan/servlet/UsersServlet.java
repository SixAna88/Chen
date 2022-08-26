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
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Vector;

@WebServlet("*.users")
public class UsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*解决乱码问题*/
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        /*获取请求的url地址信息*/
        String url = req.getRequestURI();

        /*截取其中的方法名*/
        String methodName = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
        Method method = null;

        try {
            /*使用反射机制获取在本类中声明的方法*/
            method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            /*执行方法*/
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("调用方法出错！！！");
        }
    }

    private void allUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Vector<Users> allUsers = new UsersDaoImpl().selectAllUsers();
     /*   HttpSession session = req.getSession();
        session.setAttribute("allUsers", allUsers);
        resp.sendRedirect("allUsers.jsp");
*/
        req.setAttribute("allUsers", allUsers);
        req.getRequestDispatcher("allUsers.jsp").forward(req, resp);

    }

    private void addUsers(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Users users = new Users();
        users.setUsername(req.getParameter("username"));
        users.setPassword(req.getParameter("password"));
        users.setUserPhone(req.getParameter("userPhone"));
        users.setUserAge(Integer.valueOf(req.getParameter("userAge")));
        users.setBirth(Date.valueOf(req.getParameter("birth")));

        if (new UsersDaoImpl().insertUsers(users) == 1) {
            resp.sendRedirect("/allUsers.users");
        }
    }

    private void deleteUsers(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String flag = req.getParameter("flag");

        if (flag == null) {
            new UsersDaoImpl().deleteUsers(Integer.valueOf(req.getParameter("id")));
        } else {
            String[] split = req.getParameter("id").split(",");
            for (String i : split) {
                new UsersDaoImpl().deleteUsers(Integer.parseInt(i));
            }
        }
        resp.sendRedirect("/allUsers.users");
    }

    private void updateUsers(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*生成用户对象*/
        Users users = new Users();

        /*给用户的属性赋值*/
        users.setUserId(Integer.valueOf(req.getParameter("userId")));
        users.setUsername(req.getParameter("username"));
        users.setPassword(req.getParameter("password"));
        users.setUserPhone(req.getParameter("userPhone"));
        users.setUserAge(Integer.valueOf(req.getParameter("userAge")));
        /*当日期为null时，无法正常转为date类型*/
        users.setBirth(Date.valueOf(req.getParameter("birth")));
        users.setRemark(req.getParameter("remark"));

        /*判断是否更新成功*/
        if (new UsersDaoImpl().updateUsers(users) == 1) {
            resp.sendRedirect("/allUsers.users");
        }
    }

    private void queryUsers(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{

        Vector<Users> users = null;
        String userId = req.getParameter("userId");
        String username = req.getParameter("username");

        if (userId != "") {
            users = new UsersDaoImpl().selectUsersById(Integer.parseInt(userId));
        } else {
            if (username != "") {
                users = new UsersDaoImpl().selectUsersByName(username);
            } else {
                users = new UsersDaoImpl().selectAllUsers();
            }
        }

        req.setAttribute("users", users);
        req.getRequestDispatcher("queryUsers.jsp").forward(req, resp);
    }

    private void editUsers(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        /*生成用户对象*/
        Users users = new Users();

        /*给用户的属性赋值*/
        users.setUserId(Integer.valueOf(req.getParameter("userId")));
        users.setUsername(req.getParameter("username"));
        users.setPassword(req.getParameter("password"));
        users.setUserPhone(req.getParameter("userPhone"));
        users.setUserAge(Integer.valueOf(req.getParameter("userAge")));
        /*当日期为null时，无法正常转为date类型*/
        users.setBirth(Date.valueOf(req.getParameter("birth")));
        users.setRemark(req.getParameter("remark"));

        /*判断是否更新成功*/
        if (new UsersDaoImpl().updateUsers(users) == 1) {
            HttpSession session = req.getSession();
            session.setAttribute("id", users.getUserId());
            resp.sendRedirect("/users.jsp");
        }
    }

    private void UsersShowDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Vector<Users> allUsers = new UsersDaoImpl().selectAllUsers();
        req.setAttribute("allUsers", allUsers);
        req.getRequestDispatcher("UsersShowDetail.jsp").forward(req, resp);
    }
}

