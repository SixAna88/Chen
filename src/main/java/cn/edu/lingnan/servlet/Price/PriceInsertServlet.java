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
import javax.swing.*;
import java.io.IOException;


@WebServlet("/insertPrice")
public class PriceInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Price price = new Price();
        price.setGuideId(req.getParameter("gid"));
        price.setPathId(req.getParameter("pid"));
        price.setPrice(Integer.parseInt(req.getParameter("price")));
        if ((new PriceServiceMysqlImpl().insertPrice(price)== 1)){
            JOptionPane.showMessageDialog(null, "添加成功！");
        } else {
            JOptionPane.showMessageDialog(null, "添加失败，请重试！");
        }
        resp.sendRedirect("/queryAllPrice");
    }
}
