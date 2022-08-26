package cn.edu.lingnan.Filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    //初始化：web服务器启动时，就已经初始化了，随时等待过滤对象出现！
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化.....");
    }
//    Chain: 链
    /*
    1、过滤中的所有代码，在过滤特定的请求的时候都会执行
    2、必须要让过滤器继续执行
          chain.doFilter(request,response);
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         //解决中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //直接使用setContentType()方法

        System.out.println("CharacterEncodingFilter执行前...");
        chain.doFilter(request,response);//让我们的请求继续走，如果不写，程序在这里就被拦截停止；
        System.out.println("CharacterEncodingFilter执行后...");
    }

    //销毁：web服务器关闭的时候，过滤器会销毁
    public void destroy() {
        System.gc();//通知垃圾回收站清理垃圾
        System.out.println("CharacterEncodingFilter销毁.....");
    }
}
