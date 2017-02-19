package org.usfirst.frc.falcons6443.smashboard.utilities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;

/**
 * @author Shivashriganesh Mahato
 */
public class StaticImage {

    private int x, y, width, height;
    private String path;
    private Image sprite;

    public StaticImage(int x, int y, int width, int height, String path) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setPath(path);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;

        try {
            sprite = ImageIO.read(this.getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image getSprite() {
        return sprite;
    }

    public void paint(Graphics g, ImageObserver observer) {
        g.drawImage(sprite, x, y, width, height, observer);
    }

}
