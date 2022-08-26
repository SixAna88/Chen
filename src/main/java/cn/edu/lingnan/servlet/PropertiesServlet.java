package cn.edu.lingnan.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream rs = this.getServletContext().getResourceAsStream("/WEB-INF/class/db.properties");
        Properties properties = new Properties();
        properties.load(rs);
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        resp.getWriter().println("用户名: "+ username);
        resp.getWriter().println("密码  : "+ password);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
