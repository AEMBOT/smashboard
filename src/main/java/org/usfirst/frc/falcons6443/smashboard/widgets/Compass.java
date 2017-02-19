package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * @author Shivashriganesh Mahato
 */
public class Compass extends Widget {

    public Compass(NetworkTable nTable, String spritePath, int x, int y, int width, int height) {
        super(nTable, spritePath, x, y, width, height);
    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {

    }

    @Override
    public void update(String key) {

    }

}
