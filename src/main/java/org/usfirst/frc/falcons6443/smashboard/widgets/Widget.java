package org.usfirst.frc.falcons6443.smashboard.widgets;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * @author Shivashriganesh Mahato
 */
public class Widget {

    public Widget() {
    }

    public void paint(Graphics g, Image img, int x, int y, ImageObserver observer) {
        g.drawImage(img, x, y, observer);
    }
}
