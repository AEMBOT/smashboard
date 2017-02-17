package org.usfirst.frc.falcons6443.smashboard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Shivashriganesh Mahato
 */
public class Canvas extends JPanel {

    private BufferedImage banner, barLeft, barLeftSide;
    private int leftVal;

    public Canvas() {
        try {
            banner = ImageIO.read(this.getClass().getResource("/img/BannerFinal.png"));
            barLeft = ImageIO.read(this.getClass().getResource("/img/Bar.png"));
            barLeftSide = ImageIO.read(this.getClass().getResource("/img/BarSide.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLeftVal(int leftVal) {
        this.leftVal = leftVal;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(banner, 0, 0, this);
        g.drawImage(barLeft, 0, 640, 70, -leftVal, this);
        g.drawImage(barLeftSide, 0, 140, this);
    }
}
