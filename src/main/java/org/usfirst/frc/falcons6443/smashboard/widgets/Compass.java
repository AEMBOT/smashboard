package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * A widget that displays the robot heading in a compass format
 *
 * @author Shivashriganesh Mahato
 */
public class Compass extends Widget {

    private Graphics2D g2;
    private int angle;

    /**
     * Construct the Compass with its properties
     *
     * @param nTable      The network table that the application is talking to
     * @param compassPath The path of the sprite of the compass in the resources root
     * @param x           The compass's x coordinate on the application's canvas
     * @param y           The compass's y coordinate on the application's canvas
     * @param width       The compass's width on the application's canvas
     * @param height      The compass's height on the application's canvas
     * @param angle       The compass's initial angle
     */
    public Compass(NetworkTable nTable, String compassPath, int x, int y, int width, int height, int angle) {
        super(nTable, compassPath, x, y, width, height);
        this.angle = angle;
    }

    /**
     * Paint this widget on the canvas
     *
     * @param g        The Graphics object to draw this widget on
     * @param observer The asynchronous update interface that receives notifications about Image information as the
     *                 Image is constructed.
     */
    @Override
    public void paint(Graphics g, ImageObserver observer) {
        g2 = (Graphics2D) g;
        g2.translate(x, y);
        g2.rotate(Math.toRadians(angle), width / 2, height / 2);
        g2.drawImage(sprite, 0, 0, width, height, observer);
    }

    /**
     * Update the properties and values of this widget
     * For Compass, the angle is updated based on the network table reading for the key
     *
     * @param key The key of the data that this widget belongs to, and of the record that will be read to find the
     *            updated value
     */
    @Override
    public void update(String key) {
        angle = (int) nTable.getNumber(key, 0.0);
    }

}
