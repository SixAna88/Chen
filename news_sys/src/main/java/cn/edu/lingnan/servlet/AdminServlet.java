package cn.edu.lingnan.servlet;

import cn.edu.lingnan.dao.AdminDaoImpl;
import cn.edu.lingnan.pojo.Admin;

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

@WebServlet("*.admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*解决乱码问题*/
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        /*获取请求的url地址信息*/
        String url  = req.getRequestURI();

        /*截取其中的方法名*/
        String methodName = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."));
        Method method = null;

        try {
            /*使用反射机制获取在本类中声明的方法*/
            method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            /*执行方法*/
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("调用方法出错！！！");
        }
    }

    private void allAdmin(HttpServletRequest req,HttpServletResponse resp)  throws ServletException, IOException {
        Vector<Admin> allAdmin = new AdminDaoImpl().selectAllAdmin();
        req.setAttribute("allAdmin",allAdmin);
        req.getRequestDispatcher("allAdmin.jsp").forward(req,resp);
    }

    private void addAdmin(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Admin admin = new Admin();
        admin.setUsername(req.getParameter("username"));
        admin.setPassword(req.getParameter("password"));
        admin.setRole(Integer.parseInt(req.getParameter("role")));
        admin.setCreateDate(Date.valueOf(req.getParameter("createDate")));
        if (new AdminDaoImpl().insertAdmin(admin) == 1) {
            resp.sendRedirect("allAdmin.admin");
        }
    }

    private void deleteAdmin(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String flag = req.getParameter("flag");
        if (flag == null) {
            new AdminDaoImpl().deleteAdmin(Integer.valueOf(req.getParameter("id")));
        } else {
            String[] split = req.getParameter("id").split(",");
            for (String i : split) {
                new AdminDaoImpl().deleteAdmin(Integer.parseInt(i));
            }
        }
        resp.sendRedirect("allAdmin.admin");
    }

    private void updateAdmin(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        /*生成管理员对象*/
        Admin admin = new Admin();

        /*赋值操作*/
        admin.setId(Integer.parseInt(req.getParameter("id")));
        admin.setUsername(req.getParameter("username"));
        admin.setPassword(req.getParameter("password"));
        admin.setRole(Integer.parseInt(req.getParameter("role")));
        admin.setCreateDate(Date.valueOf(req.getParameter("createDate")));
        admin.setMail(req.getParameter("mail"));
        admin.setPhone(req.getParameter("phone"));
        admin.setAge(Integer.parseInt(req.getParameter("age")));
        admin.setRemark1(req.getParameter("remark1"));
        admin.setRemark2(req.getParameter("remark2"));
        admin.setRemark3(req.getParameter("remark3"));

        /*判断是否更新成功*/
        if( new AdminDaoImpl().updateAdmin(admin)==1){
            resp.sendRedirect("allAdmin.admin");
        }
    }

    private void queryAdmin(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException  {
        Vector<Admin> admins = null;
        String username = req.getParameter("username");
        String role = req.getParameter("role");

        if (username != "") {
            if (role != "") {
                admins = new AdminDaoImpl().selectAdminByNameAndRole(username, Integer.parseInt(role));//匿名对象

            } else {
                admins = new AdminDaoImpl().selectAdminByName(req.getParameter("username"));//匿名对象
            }
        } else if (role!= "") {
            admins = new AdminDaoImpl().selectAdminByRole(Integer.parseInt(role));
        } else {
            admins = new AdminDaoImpl().selectAllAdmin();
        }

        req.setAttribute("admins",admins);
        req.getRequestDispatcher("queryAdmin.jsp").forward(req,resp);
    }

}
