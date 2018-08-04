package com.bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 带有球组件和按钮的框架
 */
public class BounceFrame extends JFrame {

    private BallComponent comp;

    public static final int STEPS = 1000;

    public static final int DELAY = 3;

    /**
     * 用组件构造fream来显示小球并开始和结束
     *
     * @throws HeadlessException
     */
    public BounceFrame() throws HeadlessException {

        setTitle("Bounce");

        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBall();
            }
        });
        addButton(buttonPanel, "Close", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    private void addBall() {
        try {
            Ball ball = new Ball();
            comp.add(ball);
            for (int i = 1; i <= STEPS; i++) {
                ball.move(comp.getBounds());
                comp.paint(comp.getGraphics());
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
            
        }
    }

    /**
     * 向联系人添加一个按钮
     *
     * @param c
     * @param title
     * @param listener
     */
    private void addButton(Container c, String title, ActionListener listener) {

        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }


}
