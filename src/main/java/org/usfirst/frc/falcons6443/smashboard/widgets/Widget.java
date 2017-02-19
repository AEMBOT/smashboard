package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;

/**
 * @author Shivashriganesh Mahato
 */
public abstract class Widget {

    protected Image sprite;
    protected int x, y, width, height;
    protected NetworkTable nTable;

    public Widget(NetworkTable nTable, String spritePath, int x, int y, int width, int height) {
        try {
            sprite = ImageIO.read(this.getClass().getResource(spritePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.nTable = nTable;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    public Image getSprite() {
        return sprite;
    }

    public abstract void paint(Graphics g, ImageObserver observer);

    public abstract void update(String key);

}
