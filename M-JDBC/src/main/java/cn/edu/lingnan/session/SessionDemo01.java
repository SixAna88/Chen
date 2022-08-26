package cn.edu.lingnan.session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码
        resp.setContentType("text/html;charset=utf-8");  //直接使用setContentType()方法
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //得到session
        HttpSession session = req.getSession();
        //存东西
        session.setAttribute("name","橙子");
        //获取session的id
        String id = session.getId();
        //判断是否新创建
        if(session.isNew()){
            resp.getWriter().write("session创建成功！ SessionId = " + id );
        }else{
            resp.getWriter().write("已经在服务器中被创建(存在),SessionId = "+ id );
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
