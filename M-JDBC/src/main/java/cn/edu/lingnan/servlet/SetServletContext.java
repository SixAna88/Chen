package cn.edu.lingnan.servlet;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SetServletContext extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Servlet上下文
        ServletContext servletContext = this.getServletContext();
        String username = "上下文";
        servletContext.setAttribute("username",username);
        System.out.println("向ServletContext对象中存入用户名:"+username);
    }
}
