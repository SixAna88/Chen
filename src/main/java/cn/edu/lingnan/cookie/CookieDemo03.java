package cn.edu.lingnan.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

//中文数据的传递
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决中文乱码
        resp.setContentType("text/html;charset=utf-8");  //直接使用setContentType()方法
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        //Cookie ,服务器端从客户端获取
        Cookie[] cookies = req.getCookies();//这里返回数组，说明存在多个Cookie

        //判断Cookie是否为null
        if(cookies!=null){
            //如果存在，遍历数组
            out.write("你上一次访问的cookie为：");

            for (int i = 0; i < cookies.length ; i++) {
                Cookie cookie = cookies[i];
                //获取cookie的名字
                if(cookie.getName().equals("name")){
//                    System.out.println(cookie.getValue());
                    out.write(URLDecoder.decode(cookie.getValue(),"UTF-8"));//解码
                }
            }
        }else{
            out.write("这是您第一次访问本站...");
        }
        //创建一个cookie
//        Cookie cookie = new Cookie("name","橙子");
        Cookie cookie = new Cookie("name", URLEncoder.encode("橙子","utf-8"));//编码
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
