package cn.edu.lingnan.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorityFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Integer superuser = (Integer) session.getAttribute("superuser");
        System.out.println("[Debug]:  权限过滤器中用户的权限为： "+ superuser);
        if(superuser!=null) {//用户已经登录
            if (superuser==1) {
                //管理员登录
                filterChain.doFilter(servletRequest,servletResponse);
            } else {
                //非管理员
                response.sendRedirect("/authority.jsp");
            }
        }else{//用户没有登录
            response.sendRedirect("/login.html");
        }
    }

    public void destroy() {

    }
}
