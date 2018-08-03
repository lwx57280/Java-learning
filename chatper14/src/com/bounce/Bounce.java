package com.bounce;

import javax.swing.*;
import java.awt.*;

/**
 * 显示一个动画的球。
 */
public class Bounce {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

    }
}
