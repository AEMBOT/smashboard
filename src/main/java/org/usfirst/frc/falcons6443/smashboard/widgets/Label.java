package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * A widget that displays simple text
 *
 * @author Shivashriganesh Mahato
 */
public class Label extends Widget {

    private String lName;
    private String value;
    private Color color;
    private Font font;

    /**
     * Construct the Label with its properties
     *
     * @param nTable The network table that the application is talking to; Make null if value should be constant
     * @param x      The label's x coordinate on the application's canvas
     * @param y      The label's y coordinate on the application's canvas
     * @param color  The color of the label's text
     * @param font   The font of the label's text
     * @param value  The value to display as the text of the label; This will stay constant if nTable is null
     */
    public Label(NetworkTable nTable, int x, int y, Color color,
                 Font font, String value) {
        super(nTable, "", x, y, 0, 0);
        this.color = color;
        this.font = font;
        this.value = value;
        lName = "";
    }

    /**
     * Accessor for lName
     *
     * @return The label's name
     */
    public String getlName() {
        return lName;
    }

    /**
     * Mutator for lName
     *
     * @param lName The new label name
     */
    public void setlName(String lName) {
        this.lName = lName;
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
        if (font != null)
            g.setFont(font);
        g.setColor(color);
        g.drawString(lName + ": " + value, x, y);
    }

    /**
     * Update the properties and values of this widget
     * For Label, value is set to the value read from the network table of the key @param key only if nTable is not
     * null. If it is null, the value is constant therefore not updated
     *
     * @param key The key of the data that this widget belongs to, and of the record that will be read to find the
     *            updated value
     */
    @Override
    public void update(String key) {
        lName = key;
        if (nTable != null)
            value = nTable.getValue(key, null).toString();
    }

}
