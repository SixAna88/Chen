package cn.edu.lingnan.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//统计网站在线人数----统计Session
public class OnlineCountListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        //一旦创建一个Session，就会触发一次这个事件
        //创建Session的监听
        ServletContext ctx = se.getSession().getServletContext();
        System.out.println(se.getSession().getId());//输出session的id
        Integer OnlineCount = (Integer) ctx.getAttribute("OnlineCount");//取参数

        if(OnlineCount==null){
            OnlineCount = new Integer(1);
        }else{
            int count =OnlineCount.intValue();
            OnlineCount = new Integer(count+1);
        }
        ctx.setAttribute("OnlineCount",OnlineCount);

    }

    public void sessionDestroyed(HttpSessionEvent se) {
        //一旦销毁一个Session，就会触发一次这个事件
        //销毁Session的监听
        ServletContext ctx = se.getSession().getServletContext();


        Integer OnlineCount = (Integer) ctx.getAttribute("OnlineCount");//取参数

        if(OnlineCount==null){
            OnlineCount = new Integer(1);
        }else{
            int count =OnlineCount.intValue();
            OnlineCount = new Integer(count-1);
        }
        ctx.setAttribute("OnlineCount",OnlineCount);
    }

    /*
    Session销毁
    1、手动销毁
    2、自动销毁
       se.getSession().invalidate();
     */
}
