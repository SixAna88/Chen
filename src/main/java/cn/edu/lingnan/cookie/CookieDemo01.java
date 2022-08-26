package cn.edu.lingnan.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


//保存用户上一次登录的时间
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //服务器，告诉你，你来的时间，把这个时间封装成为一个信件

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
            out.write("你上一次访问的时间是：");
//            for (Cookie cookie : cookies) {
//
//            }
            for (int i = 0; i < cookies.length ; i++) {
                Cookie cookie = cookies[i];
                //获取cookie的名字
                if(cookie.getName().equals("lastLoginTime")){
                    //获取Cookie中的值
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());
                }
            }
        }else{
            out.write("这是第一次访问...");
        }
        //服务器给客户端响应一个Cookie
        Cookie cookie = new Cookie("lastLoginTime",System.currentTimeMillis()+"");
        //cookie有效期为1天
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
