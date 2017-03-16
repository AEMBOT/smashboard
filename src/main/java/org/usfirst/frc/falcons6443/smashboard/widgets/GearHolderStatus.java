package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;

/**
 * Created by higgp153 on 3/11/2017.
 */
public class GearHolderStatus extends Widget {

    private Image closedSprite;
    private boolean isOpen;

    /**
     * Construct the Widget with its properties
     *
     * @param nTable     The network table that the application is talking to
     * @param x          The widget's x coordinate on the application's canvas
     * @param y          The widget's y coordinate on the application's canvas
     * @param width      The widget's width on the application's canvas
     * @param height     The widget's height on the application's canvas
     */
    public GearHolderStatus(NetworkTable nTable, String openSpritePath, String closedSpritePath, int x, int y,
                            int width, int height) {
        super(nTable, openSpritePath, x, y, width, height);
        try {
            closedSprite = ImageIO.read(this.getClass().getResource(closedSpritePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        isOpen = false;
    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {
        g.drawImage(isOpen ? sprite : closedSprite, x, y, width, height, observer);
    }

    @Override
    public void update(String key) {
        isOpen = nTable.getBoolean(key, false);
    }

}
