package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.falcons6443.smashboard.utilities.ColorUtils;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * A widget that displays a map of the field and the location of the robot relative to it
 *
 * @author Shivashriganesh Mahato
 */
public class Map extends Widget {

    private int positionX, positionY;

    /**
     * Construct the Widget with its properties
     *
     * @param nTable     The network table that the application is talking to
     * @param spritePath The path of the sprite of the widget in the resources root; If equal to "", the sprite will be
     *                   initialized to null
     * @param x          The widget's x coordinate on the application's canvas
     * @param y          The widget's y coordinate on the application's canvas
     * @param width      The widget's width on the application's canvas
     * @param height     The widget's height on the application's canvas
     * @param positionX  The x coordinate relative to the widget of the robot relative to the field
     * @param positionY  The y coordinate relative to the widget of the robot relative to the field
     */
    public Map(NetworkTable nTable, String spritePath, int x, int y, int width, int height, int positionX, int positionY) {
        super(nTable, spritePath, x, y, width, height);
        this.positionX = positionX;
        this.positionY = positionY;
        System.out.println(width);
    }

    /**
     * @param g        The Graphics object to draw this widget on
     * @param observer The asynchronous update interface that receives notifications about Image information as the
     *                 Image is constructed.
     */
    @Override
    public void paint(Graphics g, ImageObserver observer) {
        g.drawImage(sprite, x, y, width, height, observer);
        g.setColor(Color.CYAN);
        g.fillRect(ColorUtils.constrain((x + positionX), x, x + width),
                ColorUtils.constrain((y + positionY), y, y + height), 2, 2);
    }

    /**
     * The x and y positions of the robot on the field are updated based on the network table readings
     *
     * @param key The key of the data that this widget belongs to, and of the record that will be read to find the
     *            updated value
     */
    @Override
    public void update(String key) {
        positionX = Integer.parseInt(nTable.getString(key + "X", ""));
        positionY = Integer.parseInt(nTable.getString(key + "Y", ""));
    }

}
