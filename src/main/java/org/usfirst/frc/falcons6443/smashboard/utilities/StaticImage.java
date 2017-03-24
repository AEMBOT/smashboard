package org.usfirst.frc.falcons6443.smashboard.utilities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;

/**
 * A constant image that is drawn on the canvas.
 *
 * @author Shivashriganesh Mahato
 */
public class StaticImage {

    private int x, y, width, height;
    private String path;
    private Image sprite;

    /**
     * Construct the StaticImage with its properties.
     *
     * @param x      The static image's x coordinate on the application's canvas
     * @param y      The static image's y coordinate on the application's canvas
     * @param width  The static image's width on the application's canvas
     * @param height The static image's height on the application's canvas
     * @param path   The path to the image in the resources root
     */
    public StaticImage(int x, int y, int width, int height, String path) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setPath(path);
    }

    /**
     * Accessor for x.
     *
     * @return The static image's x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Mutator for x.
     *
     * @param x The new x position
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Accessor for y.
     *
     * @return The static image's y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Mutator for y.
     *
     * @param y The new y position
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Accessor for width.
     *
     * @return The static image's width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Mutator for width.
     *
     * @param width The new width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Accessor for height.
     *
     * @return The static image's height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Mutator for height.
     *
     * @param height The new height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Accessor for path.
     *
     * @return The static image's path in the resources root
     */
    public String getPath() {
        return path;
    }

    /**
     * Mutator for the path, which also sets the new image based on the new path.
     *
     * @param path The new path of the image in the resources root
     */
    public void setPath(String path) {
        this.path = path;

        try {
            sprite = ImageIO.read(this.getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Accessor for sprite.
     *
     * @return The static image's sprite (the image itself)
     */
    public Image getSprite() {
        return sprite;
    }

    /**
     * Paint this static image on the canvas.
     *
     * @param g        The Graphics object to draw this widget on
     * @param observer The asynchronous update interface that receives notifications about Image information as the
     *                 Image is constructed.
     */
    public void paint(Graphics g, ImageObserver observer) {
        g.drawImage(sprite, x, y, width, height, observer);
    }

}
