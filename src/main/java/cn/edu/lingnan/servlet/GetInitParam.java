package cn.edu.lingnan.servlet;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class GetInitParam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        String url = servletContext.getInitParameter("url");
//        方式1
        resp.getWriter().print(url);
//        方式2
//        PrintWriter writer = resp.getWriter();
//        writer.print("数据库连接路径:" + url);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
