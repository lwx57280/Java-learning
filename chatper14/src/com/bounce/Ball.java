package com.bounce;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * 从矩形的边缘移动和反弹的球
 */
public class Ball {

    private static final int XSIZE = 15;

    private static final int YSIZE = 15;

    private double x = 0;

    private double y = 0;

    private double dx = 1;

    private double dy = 1;

    /**
     * 将球移动到下一个位置，如果球碰到其中的一条边，则反转方向
     *
     * @param bounds
     */
    public void move(Rectangle2D bounds) {
        x += dx;
        y += dy;

        if (x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = -dx;
        }
        if (x + XSIZE >= bounds.getMaxY()) {
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }
        if (y < bounds.getMinY()) {
            y = bounds.getMinY();
            dy = -dy;
        }
        if (y + YSIZE >= bounds.getMaxY()) {
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }

    /**
     * 在当前位置得到球的形状。
     *
     * @return
     */
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }
}
