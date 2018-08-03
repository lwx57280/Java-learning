package com.bounce;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 画球的部件
 */
public class BallComponent extends JPanel {

    private static final int DEFAULT_WIDTH = 450;

    private static final int DEFAULT_HEIGHT = 350;

    private List<Ball> balls = new ArrayList<Ball>();

    /**
     * 向组件添加一个球
     *
     * @param b
     */
    public void add(Ball b) {
        balls.add(b);

    }


    public void paintComponent(Graphics g) {
        // 擦除背景
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls) {
            g2.fill(b.getShape());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
