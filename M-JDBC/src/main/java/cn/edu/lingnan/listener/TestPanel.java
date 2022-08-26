package cn.edu.lingnan.listener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame("情人节快乐");//新建一个窗体
        Panel panel = new Panel(null);//生成一个面板

        frame.setLayout(null);//设置窗体布局
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(28, 208,255));//设置背景色
        panel.setBounds(50,50,300,300);
        panel.setBackground(new Color(190, 193, 255));

        frame.add(panel);
        frame.setVisible(true);

        //监听窗体关闭事件
        frame.addWindowListener(new WindowAdapter() {
           @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.out.println("关闭ing");
                System.exit(0);
            }
        });
    }
}
