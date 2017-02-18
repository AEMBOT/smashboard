package org.usfirst.frc.falcons6443.smashboard;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.falcons6443.smashboard.utilities.StaticImage;
import org.usfirst.frc.falcons6443.smashboard.widgets.Widget;

import javax.swing.*;
import java.awt.*;

/**
 * @author Shivashriganesh Mahato
 */
public class Dashboard extends JFrame {

    private String title;
    private Color bgColor;
    private boolean isResizable;
    private int width, height;
    private Canvas canvas;
    private NetworkTable nTable;

    public Dashboard(String ipAddress, String nTableKey, String title, Color bgColor, boolean isResizable, int width,
                     int height) {
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

    public void run() {
        setVisible(true);
    }

    public void update() {
        canvas.repaint();
    }

    public void addSImage(String path, int x, int y, int width, int height) {
        canvas.addSImage(new StaticImage(x, y, width, height, path));
    }

    public void addData(String key, Widget widget) {
        if (!doesDataExist(key))
            canvas.addData(new Data(key, widget));
        else
            System.out.println("Error: Data with key " + key + " already exists.");
    }

    public boolean doesDataExist(String key) {
        for (Data data : canvas.getDatas())
            if (data.getKey().equals(key))
                return true;
        return false;
    }

    public Data getData(String key) {
        return canvas.getData(key);
    }

    public Widget getWidget(String key) {
        return canvas.getWidget(key);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    @Override
    public boolean isResizable() {
        return isResizable;
    }

    @Override
    public void setResizable(boolean resizable) {
        isResizable = resizable;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
