package com.Frame.GreenOrange.Find_ing;

import com.Button.GreenOrange.Find_ing.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("InfiniteLoopStatement")

public class MainFrame {
    public JTextArea OnlyRead;
    public String Test = "hello";
    public String message;

    public void mainframe() throws IOException {

        JFrame jf = new JFrame("平平无奇的聊天框");
        jf.setSize(300, 500);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jf.setResizable(false);
        jf.setAlwaysOnTop(true);


        JPanel panel = new JPanel(null);
        panel.setBackground(Color.decode("#F7F4D1"));
        panel = setPanel(panel);


        jf.setContentPane(panel);
        jf.setVisible(true);

        String ServerAddress = "172.17.49.246";
        Socket socket = new Socket(ServerAddress, 10828);
        try (OutputStream oup = socket.getOutputStream()) {
            try (InputStream inp = socket.getInputStream()) {

                while (true){
                    oup.write(Test.getBytes(StandardCharsets.UTF_8));
                    oup.flush();
                    byte[] bytes = new byte[4096];
                    int len = inp.read(bytes);
                    String response = new String(bytes, 0, len);
                    message = response;
//                    System.out.println(frame.message);
                    if (response.equals(" ")) continue;
                    System.out.println(response);
                    OnlyRead.append("服务端："+response+"\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public JPanel setPanel(JPanel panel){
        JLabel lb1 = new JLabel("172.17.49.246");
        JLabel lb2 = new JLabel("----------------------------------------------------------------------------------");
        lb1.setBounds(90, 10, 200, 20);
        lb2.setBounds(0, 28, 300, 10);
        lb1.setFont(new  Font("华文行楷", Font.BOLD,  15));
        panel.add(lb1);
        panel.add(lb2);


        OnlyRead = new JTextArea(3000,30);
        OnlyRead.setLineWrap(true);
        OnlyRead.setFont(new  Font("微软雅黑", Font.BOLD,  15));
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

        MyButton._nok(jb2);
        MyButton._ok(jb1);

        jb1.setLocation(200, 430);
        jb2.setLocation(32, 430);

        jb2.addActionListener(e -> System.exit(0));

        jb1.addActionListener(e -> {
            Test = ta.getText();
            ta.setText("");
            OnlyRead.append("你自己: " + Test + "\n");
        });

        panel.add(jb1);
        panel.add(jb2);


        return panel;
    }

    public void newFrame(String mes){
        JFrame jf = new JFrame("哦豁");
        jf.setSize(400, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel jp = new JPanel(null);
        JLabel jb = new JLabel(mes);
        jp.setBackground(Color.decode("#F7F4D1"));
        jb.setBounds(10, 10, 400,100);
        jb.setFont(new  Font("华文行楷",  1,  15));
        jp.add(jb);

        JButton btn_ok = new JButton("确定");
        JButton btn_show = new JButton("我想再看看");
        btn_show.setBounds(40,110 , 130, 23);
        btn_show.setBackground(Color.decode("#91BF45"));

        btn_ok.setLocation(250, 110);

        MyButton._nok(btn_ok);


        btn_ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btn_show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mainframe();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        jp.add(btn_ok);
        jp.add(btn_show);

        jf.setContentPane(jp);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new MainFrame().newFrame("哦豁，服务器没有打开哟，先通知管理员打开服务器");
        new MainFrame();
    }
}
