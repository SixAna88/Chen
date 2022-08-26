package cn.edu.lingnan.servlet;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        this.getInitParameter();  初始化参数
//        this.getServletConfig();  Servlet配置
//        this.getServletContext(); Servlet上下文
        resp.sendRedirect("/main.html");
        System.out.println("hello World!");
    }
}