package cn.edu.lingnan.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //ServletRequest HttpServletRequest

        HttpServletRequest request1 = (HttpServletRequest) request ;
        HttpServletResponse response1 = (HttpServletResponse) response ;

        if(request1.getSession().getAttribute("USER_SESSION") == null){
            response1.sendRedirect("../jsp/failed.jsp");
        }
        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
