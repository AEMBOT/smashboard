package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * @author Shivashriganesh Mahato
 */
public class Clock extends Widget {

    private long initTime;
    private int minutes;
    private int seconds;
    private String time;
    private Color tickClr, tockClr;

    /**
     * Construct the Widget with its properties
     *
     * @param nTable     The network table that the application is talking to
     * @param spritePath The path of the sprite of the widget in the resources root; If equal to "", the sprite will be
     *                   initialized to null
     * @param x          The widget's x coordinate on the application's canvas
     * @param y          The widget's y coordinate on the application's canvas
     * @param size       The clock font size
     */
    public Clock(NetworkTable nTable, String spritePath, int x, int y, int size, int defaultMin,
                 int defaultSec, Color tickClr, Color tockClr) {
        super(nTable, spritePath, x, y, size, size);
        this.minutes = defaultMin;
        this.seconds = defaultSec;
        this.tickClr = tickClr;
        this.tockClr = tockClr;
        time = String.valueOf(minutes) + ":" + String.valueOf(seconds);
        initTime = System.currentTimeMillis();
    }

    public Clock(NetworkTable nTable, String spritePath, int x, int y, int size, Color tickClr, Color tockClr) {
        this(nTable, spritePath, x, y, size, 0, 0, tickClr, tockClr);
    }

    public Clock(NetworkTable nTable, String spritePath, int x, int y, Color tickClr, Color tockClr) {
        this(nTable, spritePath, x, y, 12, tickClr, tockClr);
    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {
        g.setColor(Color.CYAN);
//        g.fillRect(x, y - height,
//                (int) (((width / 2) * time.length()) + (width * 0.1)),
//                (int) (height + (height * 0.25)));
        g.fillArc(x, y - height, (int) (((width / 2) * time.length()) + (width * 0.1)),
                (int) (height + (height * 0.25)),
                0, 360);
        g.setColor(Color.BLACK);
        g.fillArc(
                (int) (x + (width * 0.1)),
                (int) ((y - height) + (height * 0.1)),
                (int) (((width / 2) * time.length()) + (width * 0.1)),
                (int) (((width / 2) * time.length()) + (width * 0.1)),
                0, 180);
        g.setColor(seconds % 2 == 0 ? tickClr : tockClr);
        g.setFont(g.getFont().deriveFont((float) width));
        g.drawString(time, x, y);
    }

    @Override
    public void update(String key) {
        seconds = (int) ((System.currentTimeMillis() - initTime) / 1000);
        time = String.valueOf(minutes) + ":" + String.valueOf(seconds);
    }

}
