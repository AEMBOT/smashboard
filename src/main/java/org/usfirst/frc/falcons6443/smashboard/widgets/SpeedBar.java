package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.falcons6443.smashboard.utilities.ColorUtils;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * A widget that displays the readings from the gamepad (the control read is based on the driving command that is setup)
 * on a scale. This aides the driver with an easy display for the speed of the robot on either side.
 *
 * @author Shivashriganesh Mahato
 */
public class SpeedBar extends Widget {

    private boolean isFlipped;
    private Color initClr, terminalClr, lerpedClr;
    private int barHeight;
    private int interpDegree;

    /**
     * Construct the SpeedBar with its properties
     *
     * @param nTable       The network table that the application is talking to
     * @param barSprite    The path of the sprite of the speed bar in the resources root
     * @param x            The speed bar's x coordinate on the application's canvas
     * @param y            The speed bar's y coordinate on the application's canvas
     * @param width        The speed bar's width on the application's canvas
     * @param height       The speed bar's height on the application's canvas
     * @param isFlipped    Should the speed bar be flipped?
     * @param initClr      The color of the bar when the proportional value is 0 (lowest)
     * @param terminalClr  The color of the bar when the proportional value is 1 (highest)
     * @param interpDegree The degrees of the equation used to calculate the interpolated color
     */
    public SpeedBar(NetworkTable nTable, String barSprite, int x, int y, int width, int height, boolean isFlipped,
                    Color initClr, Color terminalClr, int interpDegree) {
        super(nTable, barSprite, x, y, width, height);
        this.isFlipped = isFlipped;
        this.initClr = initClr;
        this.terminalClr = terminalClr;
        this.lerpedClr = initClr;
        this.interpDegree = interpDegree;
        barHeight = 0;
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
        g.setColor(lerpedClr);
        if (!isFlipped)
            g.fillRect(x, ((y + height) - barHeight), width, barHeight);
        else
            g.fillRect(x - Math.abs(width), ((y + height) - barHeight), Math.abs(width), barHeight);
        g.drawImage(sprite, x, y, width, height, observer);
    }

    /**
     * Update the properties and values of this widget
     * For SpeedBar, the height and color are updated based on the network table readings (the color is interpolated)
     *
     * @param key The key of the data that this widget belongs to, and of the record that will be read to find the
     *            updated value
     */
    @Override
    public void update(String key) {
        barHeight = (int) ((nTable.getNumber(key, 0.0) / 100) * height);
        lerpedClr = ColorUtils.colorInterp(initClr, terminalClr,
                (float) ((nTable.getNumber(key, 0.0) / 100)), interpDegree);
    }

}
