package org.usfirst.frc.falcons6443.smashboard.layout;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.falcons6443.smashboard.Data;
import org.usfirst.frc.falcons6443.smashboard.utilities.StaticImage;
import org.usfirst.frc.falcons6443.smashboard.widgets.SpeedBar;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.annotation.Documented;
import java.util.ArrayList;

/**
 * A Layout object is just a simple collection of StaticImage and Data objects.
 *
 * Basically a glorified Canvas, except that the Canvas is where the actual drawing takes place.
 *
 * @author Christopher Medlin
 */
public class Layout {
    private ArrayList<StaticImage> staticImages;
    private ArrayList<Data> data;

    private NetworkTable ntable;

    /**
     * Initializes a Layout object with an empty Data and StaticImages
     * ArrayList, both with an initial size of 5.
     */
    public Layout () {
        staticImages = new ArrayList<>(5);
        data = new ArrayList<>(5);
    }

    /**
     * Returns the ArrayList of Data objects contained by this Layout.
     *
     * @return the ArrayList of Data objects contained by this Layout.
     */
    public ArrayList<Data> getData() {
        return data;
    }

    /**
     * Returns the ArrayList of StaticImage objects contained by this Layout.
     *
     * @return the ArrayList of StaticImage objects contained by this Layout.
     */
    public ArrayList<StaticImage> getSI() {
        return staticImages;
    }

    /**
     * Add a Data object to the Layout.
     *
     * @param d the Data object to be added.
     */
    public void addData (Data d) {
        data.add(d);
    }

    /**
     * Add a StaticImage object to the Layout.
     *
     * @param si the StaticImage object to be added.
     */
    public void addSI (StaticImage si) {
        staticImages.add(si);
    }

}
