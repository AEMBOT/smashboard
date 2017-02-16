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

    public Canvas() {
        try {
            banner = ImageIO.read(new File("src/main/resources/BannerFinal.png"));
            barLeft = ImageIO.read(new File("src/main/resources/Bar.png"));
            barLeftSide = ImageIO.read(new File("src/main/resources/BarSide.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(banner, 0, 0, this);
        g.drawImage(barLeft, 0, 640, 70, -70, this);
        g.drawImage(barLeftSide, 0, 140, this);
    }
}
