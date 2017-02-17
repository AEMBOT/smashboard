package org.usfirst.frc.falcons6443.smashboard;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.falcons6443.smashboard.widgets.Widget;

import javax.swing.*;
import java.awt.*;

/**
 * @author Shivashriganesh Mahato
 */
public class Dashboard extends JFrame {

    private String _title;
    private Color bgColor;
    private boolean isResizable;
    private int width, height;
    private Canvas canvas;
    private NetworkTable nTable;

    public Dashboard(String ipAddress, String nTableKey, String _title, Color bgColor, boolean isResizable, int width,
                     int height) {
        NetworkTable.setClientMode();
        NetworkTable.setIPAddress(ipAddress);
        nTable = NetworkTable.getTable(nTableKey);

        canvas = new Canvas();

        this._title = _title;
        this.bgColor = bgColor;
        this.isResizable = isResizable;
        this.width = width;
        this.height = height;
    }

    public void init() {
        canvas.setBackground(bgColor);
        add(canvas);

        setTitle(_title);
        getContentPane().setBackground(bgColor);
        setResizable(isResizable);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void run() {
        setVisible(true);
    }

    public void update() {
        canvas.repaint();
    }

    public void addData(Data data) {
        canvas.addData(data);
    }

    public<T extends Widget> void addData(String key, Class<T> widgetType) {
        canvas.addData(new Data(key, widgetType));
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String title) {
        this._title = title;
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
