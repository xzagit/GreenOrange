package com.Frame.GreenOrange.Find_ing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;


import java.util.Timer;



public class MainFrame {
    JTextArea OnlyRead = new JTextArea(3000,30);

    public String Test = "hello";
    public String message;

    public MainFrame() {
        JFrame jf = new JFrame("平平无奇的聊天框");
        jf.setSize(300, 500);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setAlwaysOnTop(true);


        JPanel panel = new JPanel(null);
        panel.setBackground(Color.decode("#F7F4D1"));
        panel = setPanel(panel);


        jf.setContentPane(panel);
        jf.setVisible(true);

    }



    public void time() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                OnlyRead.append("888");
            }
        }, 10, 100);
    }

    public JPanel setPanel(JPanel panel){
        JLabel lb1 = new JLabel("172.17.49.246");
        JLabel lb2 = new JLabel("----------------------------------------------------------------------------------");
        lb1.setBounds(90, 10, 200, 20);
        lb2.setBounds(0, 28, 300, 10);
        lb1.setFont(new  Font("华文行楷",  1,  15));
        panel.add(lb1);
        panel.add(lb2);


        // TODO 文本区域
        OnlyRead.setLineWrap(true);
        OnlyRead.setFont(new  Font("微软雅黑",  1,  15));
        OnlyRead.setEditable(false);
        OnlyRead.setBackground(Color.decode("#DBD1C1"));
        JScrollPane scroll = new JScrollPane(OnlyRead);
        scroll.setBounds(10, 50, 270, 260);
        panel.add(scroll);




        //输入的文本区域
        JTextArea ta = new JTextArea(8,25);
        ta.setLineWrap(true);
        ta.setText("这里是文本输入区域");
        ta.setBackground(Color.decode("#F3F0EB"));
        ta.setFont(new  Font("微软雅黑",  4,  15));
        ta.setBounds(20, 320, 250, 100);
        panel.add(ta);

        //发送按钮
        JButton jb1 = new JButton("发送");
        JButton jb2 = new JButton("关闭");
        jb1.setBackground(Color.decode("#91BF45"));
        jb2.setBackground(Color.decode("#EE7C76"));
        jb1.setBounds(200, 430, 68, 23);
        jb2.setBounds(32, 430, 68, 23);
        jb1.setFont(new Font("微软雅黑", Font.BOLD, 11));
        jb2.setFont(new Font("微软雅黑", Font.BOLD, 11));

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Test = ta.getText();
            }
        });

        OnlyRead.append("11123");
        panel.add(jb1);
        panel.add(jb2);


        return panel;
    }

    public void newFrame(){
        JFrame jf = new JFrame("哦豁");
        jf.setSize(100, 100);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel jp = new JPanel();
        JLabel jb = new JLabel("是的，是憨批");
        jp.add(jb);
        jf.setContentPane(jp);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
