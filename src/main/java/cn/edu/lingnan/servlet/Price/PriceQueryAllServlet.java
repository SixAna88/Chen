package cn.edu.lingnan.servlet.Price;

import cn.edu.lingnan.pojo.Path;
import cn.edu.lingnan.pojo.Price;
import cn.edu.lingnan.service.PathServiceMysqlImpl;
import cn.edu.lingnan.service.PriceServiceMysqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;

@WebServlet("/queryAllPrice")
public class PriceQueryAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        GuideServiceMysqlImpl guideServiceMysql =new GuideServiceMysqlImpl();
//        Vector<Guide> guides = guideServiceMysql.findAllGuide();

        Vector<Price> prices = new PriceServiceMysqlImpl().queryAllPrice();
        System.out.println("[debug]: 价格信息一共有: "+ prices.size()+ "条记录");
        HttpSession session = req.getSession();
        session.setAttribute("allPrice",prices);
        resp.sendRedirect("/allPrice.jsp");
    }
}
