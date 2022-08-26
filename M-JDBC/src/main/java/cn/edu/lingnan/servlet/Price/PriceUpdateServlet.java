package cn.edu.lingnan.servlet.Price;

import cn.edu.lingnan.pojo.Guide;
import cn.edu.lingnan.pojo.Price;
import cn.edu.lingnan.service.GuideServiceMysqlImpl;
import cn.edu.lingnan.service.PriceServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePrice")
public class PriceUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Price price = new Price();
        System.out.println("[Debug]: " + req.getParameter("gid"));
        price.setGuideId(req.getParameter("gid"));
        price.setPathId(req.getParameter("pid"));
        price.setPrice(Integer.parseInt(req.getParameter("price")));
        System.out.println("[Debug] 待修改价格信息" + price);
        new PriceServiceMysqlImpl().updatePrice(price);
        resp.sendRedirect("/queryAllPrice");
    }
}
