package com.Button.GreenOrange.Find_ing;

import javax.swing.*;
import java.awt.*;

public class MyButton {
    public static void _ok(JButton jb){
        jb.setSize(68, 23);
        jb.setBackground(Color.decode("#91BF45"));
        jb.setFont(new Font("微软雅黑", Font.BOLD, 11));
    }
    public static void _nok(JButton jb){
        jb.setSize(68, 23);
        jb.setBackground(Color.decode("#EE7C76"));
        jb.setFont(new Font("微软雅黑", Font.BOLD, 11));
    }
}
