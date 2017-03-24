package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.falcons6443.smashboard.utilities.StaticImage;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

/**
 * A widget that displays the robot heading in a compass format.
 *
 * @author Shivashriganesh Mahato
 */
public class Compass extends Widget {

    private AffineTransform initTransform;
    private Graphics2D g2;
    private StaticImage back, fore;
    private int angle;

    /**
     * Construct the Compass with its properties.
     *
     * @param nTable      The network table that the application is talking to
     * @param compassPath The path of the sprite of the compass in the resources root
     * @param x           The compass's x coordinate on the application's canvas
     * @param y           The compass's y coordinate on the application's canvas
     * @param width       The compass's width on the application's canvas
     * @param height      The compass's height on the application's canvas
     * @param angle       The compass's initial angle
     * @param back        The sprite for the back of the compass
     * @param fore        The sprite for the front of the compass
     */
    public Compass(NetworkTable nTable, String compassPath, int x, int y, int width, int height, int angle,
                   StaticImage back, StaticImage fore) {
        super(nTable, compassPath, x, y, width, height);
        this.angle = angle;
        this.back = back;
        this.fore = fore;
        initTransform = new AffineTransform();
    }

    /**
     * Paint this widget on the canvas.
     *
     * @param g        The Graphics object to draw this widget on
     * @param observer The asynchronous update interface that receives notifications about Image information as the
     *                 Image is constructed.
     */
    @Override
    public void paint(Graphics g, ImageObserver observer) {
        // Draw the back
        back.paint(g, observer);

        // Store the current transformation so it can be reset after transforming the compass
        g2 = (Graphics2D) g;
        initTransform = g2.getTransform();

        // Draw the needle
        g2.translate(x, y);
        g2.rotate(Math.toRadians(angle), width / 2, height / 2);
        g2.drawImage(sprite, 0, 0, width, height, observer);

        // Draw the fore
        g2.translate(-x, -y);
        g2.rotate(0, width / 2, height / 2);
        fore.paint(g, observer);

        // Reset transformation to before compass was transformed
        g2.setTransform(initTransform);
    }

    /**
     * Update the angle of rotation of the robot based on NavX readings.
     *
     * @param key The key of the data that this widget belongs to, and of the record that will be read to find the
     *            updated value
     */
    @Override
    public void update(String key) {
        angle = (int) nTable.getNumber(key, 0.0);
    }

    /**
     * Accessor for angle.
     *
     * @return The rotational angle of the robot
     */
    public int getAngle() {
        return angle;
    }

}
