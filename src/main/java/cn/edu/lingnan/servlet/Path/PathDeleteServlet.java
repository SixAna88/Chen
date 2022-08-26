package cn.edu.lingnan.servlet.Path;

import cn.edu.lingnan.service.GuideServiceMysqlImpl;
import cn.edu.lingnan.service.PathServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deletePath")
public class PathDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、
        String pid = req.getParameter("pid");
        String flag =req.getParameter("flag");
        System.out.println("[Debug]删除标志位flag："+ flag);
        //2、
        if(flag==null){
            System.out.println("[Debug]： 现在进行的是单个导游记录的删除操作，待删除导游编号为 "+ pid);
            new PathServiceMysqlImpl().deletePathByPid(pid);
        }
        //3、
        else{
            System.out.println("[Debug]： 现在进行的是批量删除导游记录的操作，待删除导游编号为 "+ pid);
            String[] split = pid.split(",");
            for (String s:split) {
                new PathServiceMysqlImpl().deletePathByPid(s);
            }
        }
        resp.sendRedirect("/queryAllPath");
    }
}
