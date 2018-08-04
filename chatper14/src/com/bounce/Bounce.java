package com.bounce;

import javax.swing.*;
import java.awt.*;

/**
 * 显示一个动画的球。
 */
public class Bounce {

    public static void main(String[] args) {
        // java lambda表达式语法,java7 及以前的写法new Runnable()
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

    }
}
