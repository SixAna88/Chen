package cn.edu.lingnan.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        -如何让浏览器五秒自动刷新一次
        resp.setHeader("refresh","3");
        
//        -在内存中创建一个图片
        BufferedImage bufferedImage = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);

//        -得到图片
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();//笔

//        -设置背景颜色
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,80,20);

//        -给图片写数据
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font(null,Font.BOLD,20));
        graphics.drawString(setNum(),0,20);

//        -告诉浏览器，这个请求以图片形式打开
        resp.setContentType("image/jpg");

//        -网站存在缓存，不让浏览器缓存
        resp.setDateHeader("expires",-1);
//        设置不缓存
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

//        -把图片写给浏览器
        boolean write = ImageIO.write(bufferedImage,"jpg", resp.getOutputStream());
    }

//    -生成随机数
    private String setNum(){
        Random r = new Random();
        String num = r.nextInt(9999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7 - num.length() ; i++) {
            sb.append("0");//  0填充，保证这个数一定是七位数
        }
        String s = sb.toString() + num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
