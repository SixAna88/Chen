package cn.edu.lingnan.servlet.Price;

import cn.edu.lingnan.service.PathServiceMysqlImpl;
import cn.edu.lingnan.service.PriceServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deletePrice")
public class PriceDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、
        String pid = req.getParameter("pid");
        String gid = req.getParameter("gid");
        String flag = req.getParameter("flag");
        System.out.println("[Debug]删除标志位flag：" + flag);
        //2、
        if (flag == null) {
            new PriceServiceMysqlImpl().deletePriceByGidAndPid(gid, pid);
        }
//        //3、
//        else {
//            String[] split = gid.split(",");
//            String[] split1 = pid.split(",");
//            for (String s : split) {
//                for (String p : split1) {
//                    new PriceServiceMysqlImpl().deletePriceByGidAndPid(s,p);
//                }
//            }
//        }
        resp.sendRedirect("/queryAllPrice");
    }
}
