package cn.edu.lingnan.servlet;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext 实现请求转发
 */

public class GetRequestDispatcher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();

//        //转发的路径
//        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/getParam");
//        //调用forward方法实现请求转发
//        requestDispatcher.forward(req,resp);

//        等价于
        servletContext.getRequestDispatcher("/getParam").forward(req,resp);

        System.out.println("进入了GetRequestDispatcher");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
