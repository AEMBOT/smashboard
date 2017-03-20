package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.IOException;

/**
 * Represents a visual display of data on the canvas
 *
 * @author Shivashriganesh Mahato
 */
public abstract class Widget implements MouseListener {

    protected Image sprite;
    protected int x, y, width, height;
    protected NetworkTable nTable;

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
     */
    public Widget(NetworkTable nTable, String spritePath, int x, int y, int width, int height) {
        if (spritePath.equals(""))
            sprite = null;
        else {
            try {
                sprite = ImageIO.read(this.getClass().getResource(spritePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.nTable = nTable;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Accessor for x
     *
     * @return The static image's x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Mutator for x
     *
     * @param x The new x position
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Accessor for y
     *
     * @return The static image's y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Mutator for y
     *
     * @param y The new y position
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Accessor for width
     *
     * @return The static image's width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Mutator for width
     *
     * @param width The new width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Accessor for height
     *
     * @return The static image's height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Mutator for height
     *
     * @param height The new height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Accessor for sprite
     *
     * @return The widget's sprite
     */
    public Image getSprite() {
        return sprite;
    }

    /**
     * Paint this widget on the canvas
     *
     * @param g        The Graphics object to draw this widget on
     * @param observer The asynchronous update interface that receives notifications about Image information as the
     *                 Image is constructed.
     */
    public abstract void paint(Graphics g, ImageObserver observer);

    /**
     * Update the properties and values of this widget
     *
     * @param key The key of the data that this widget belongs to, and of the record that will be read to find the
     *            updated value
     */
    public abstract void update(String key);

    /**
     * Invoked when the mouse button has been clicked (pressed and released) on the canvas
     *
     * @param mouseEvent Properties of the mouse at this event
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {}

    /**
     * Invoked when a mouse button has been pressed on the canvas
     *
     * @param mouseEvent Properties of the mouse at this event
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {}

    /**
     * Invoked when a mouse button has been released on the canvas
     *
     * @param mouseEvent Properties of the mouse at this event
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {}

    /**
     * Invoked when the mouse enters the canvas
     *
     * @param mouseEvent Properties of the mouse at this event
     */
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}

    /**
     * Invoked when the mouse exits the canvas
     *
     * @param mouseEvent Properties of the mouse at this event
     */
    @Override
    public void mouseExited(MouseEvent mouseEvent) {}

}
