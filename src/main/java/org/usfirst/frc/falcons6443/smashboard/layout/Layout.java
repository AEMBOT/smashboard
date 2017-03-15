package org.usfirst.frc.falcons6443.smashboard.layout;

import org.usfirst.frc.falcons6443.smashboard.Data;
import org.usfirst.frc.falcons6443.smashboard.utilities.StaticImage;

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

    public Layout () {
        staticImages = new ArrayList<>(5);
        data = new ArrayList<Data>(5);
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
