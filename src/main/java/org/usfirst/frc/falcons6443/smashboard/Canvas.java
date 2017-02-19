package org.usfirst.frc.falcons6443.smashboard;

import org.usfirst.frc.falcons6443.smashboard.utilities.StaticImage;
import org.usfirst.frc.falcons6443.smashboard.widgets.Widget;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel where all components are drawn and data objects are stored
 *
 * @author Shivashriganesh Mahato
 */
public class Canvas extends JPanel {

    // The lists of components that will be on this canvas
    private ArrayList<Data> datas;
    private ArrayList<StaticImage> staticImages;

    /**
     * Construct the Canvas with empty lists of components
     */
    public Canvas() {
        datas = new ArrayList<>();
        staticImages = new ArrayList<>();
    }

    /**
     * Get data from the list of data
     *
     * @param key The key of the data to fetch
     * @return The data that is fetched
     */
    public Data getData(String key) {
        for (Data data : datas)
            if (data.getKey().equals(key))
                return data;
        return null;
    }

    /**
     * Get a widget from the list of data
     *
     * @param key The key of the data that the widget belongs to
     * @return The widget that is fetched
     */
    public Widget getWidget(String key) {
        return getData(key).getWidget();
    }

    /**
     * Accessor for datas
     *
     * @return The canvas's list of data
     */
    public ArrayList<Data> getDatas() {
        return datas;
    }

    /**
     * Add a new Data object to this canvas
     *
     * @param data The data to add
     */
    public void addData(Data data) {
        datas.add(data);
    }

    /**
     * Add a new StaticImage object to this canvas
     *
     * @param image The static image to add
     */
    public void addSImage(StaticImage image) {
        staticImages.add(image);
    }

    /**
     * Calls the UI delegate's paint method, if the UI delegate is non-null.
     *
     * @param g The Graphics object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (StaticImage sImage : staticImages)
            sImage.paint(g, this);
        for (Data data : datas)
            data.getWidget().paint(g, this);
    }

}
