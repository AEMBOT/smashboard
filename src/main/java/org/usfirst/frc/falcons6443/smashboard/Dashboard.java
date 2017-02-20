package org.usfirst.frc.falcons6443.smashboard;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.falcons6443.smashboard.utilities.StaticImage;
import org.usfirst.frc.falcons6443.smashboard.widgets.Widget;

import javax.swing.*;
import java.awt.*;

/**
 * Defines the frame that a canvas is drawn on, holding the properties of an application itself
 *
 * @author Shivashriganesh Mahato
 */
public class Dashboard extends JFrame {

    private String title;
    private Color bgColor;
    private boolean isResizable;
    private int width, height;
    private Canvas canvas;
    private NetworkTable nTable;

    /**
     * Construct the Dashboard with the properties of the application
     *
     * @param ipAddress   The IP Address of the RoboRIO (where the wanted NetworkTables are stored) to connect to
     * @param nTableKey   The name of the NetworkTable to retrieve data from (if it doesn't exist already, it will be
     *                    created here)
     * @param title       The title of the application (will be displayed in the menu bar)
     * @param bgColor     The background color of the application
     * @param isResizable Should the user be allowed to resize the application?
     * @param width       The width of the application
     * @param height      The height of the application
     */
    public Dashboard(String ipAddress, String nTableKey, String title, Color bgColor, boolean isResizable, int width,
                     int height) {
        // Setup the network table connection from the application to act as a client, then connect to it and fetch the
        // appropriate table
        NetworkTable.setClientMode();
        NetworkTable.setIPAddress(ipAddress);
        nTable = NetworkTable.getTable(nTableKey);

        canvas = new Canvas();
        this.title = title;
        this.bgColor = bgColor;
        this.isResizable = isResizable;
        this.width = width;
        this.height = height;
    }

    /**
     * Initialize the application with a canvas and properties set based on the field defined in the construction of
     * this object
     */
    public void init() {
        canvas.setBackground(bgColor);
        add(canvas);

        setTitle(title);
        getContentPane().setBackground(bgColor);
        setResizable(isResizable);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Run the application
     */
    public void run() {
        setVisible(true);
    }

    /**
     * Update the data of the application
     */
    public void update() {
        canvas.repaint();
        for (Data data : canvas.getDatas())
            data.update();
    }

    /**
     * Add a Static Image to the application's canvas
     *
     * @param path   The path of the image in the resources root
     * @param x      The x coordinate of the image on the canvas
     * @param y      The y coordinate of the image on the canvas
     * @param width  The width of the image on the canvas
     * @param height The height of the image on the canvas
     */
    public void addSImage(String path, int x, int y, int width, int height) {
        canvas.addSImage(new StaticImage(x, y, width, height, path));
    }

    /**
     * Add data to the application that will be displayed on the canvas
     *
     * @param key    The unique identifier of the data; also the key of the network table record that will be used to
     *               display the widget
     * @param widget The widget that will be displayed on the canvas, and will have updated values based on the
     *               network table record with the key @param key
     */
    public void addData(String key, Widget widget) {
        if (!doesDataExist(key))
            canvas.addData(new Data(key, widget));
        else
            System.out.println("Error: Data with key " + key + " already exists.");
    }

    /**
     * Check if a data entity exists in the canvas's data list
     *
     * @param key The key of the data entity to look for
     * @return Does a data entity with the key @param key exist?
     */
    public boolean doesDataExist(String key) {
        for (Data data : canvas.getDatas())
            if (data.getKey().equals(key))
                return true;
        return false;
    }

    /**
     * Get data from the canvas
     *
     * @param key The key of the data to fetch
     * @return The data that is fetched
     */
    public Data getData(String key) {
        return canvas.getData(key);
    }

    /**
     * Get a widget from the canvas
     *
     * @param key The key of the data that the widget belongs to
     * @return The widget that is fetched
     */
    public Widget getWidget(String key) {
        return canvas.getWidget(key);
    }

    /**
     * Accessor for canvas
     *
     * @return This application's canvas
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * Accessor for title
     *
     * @return This application's title
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Mutator for title
     *
     * @param title The new title
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Accessor for BgColor
     *
     * @return This application's background color
     */
    public Color getBgColor() {
        return bgColor;
    }

    /**
     * Mutator for BgColor
     *
     * @param bgColor The new background color
     */
    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    /**
     * Accessor for isResizable
     *
     * @return Is this application resizable?
     */
    @Override
    public boolean isResizable() {
        return isResizable;
    }

    /**
     * Mutator for isResizable
     *
     * @param resizable Should this application be resizable?
     */
    @Override
    public void setResizable(boolean resizable) {
        isResizable = resizable;
    }

    /**
     * Accessor for width
     *
     * @return This application's width
     */
    @Override
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
     * @return This application's height
     */
    @Override
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
     * Accessor for nTable
     *
     * @return The network table that this application talks to
     */
    public NetworkTable getNTable() {
        return nTable;
    }

}
