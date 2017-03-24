package org.usfirst.frc.falcons6443.smashboard;

import org.usfirst.frc.falcons6443.smashboard.widgets.Widget;

/**
 * Defines a data component that holds a key and value; the value should be updated based NetworkTable data.
 *
 * @author Shivashriganesh Mahato
 */
public class Data {

    private String key;
    private Widget widget;

    /**
     * Construct this Data with the key and value.
     *
     * @param key    The unique identifier of the data; also the key of the network table record that will be used to
     *               display the widget
     * @param widget The widget that will be displayed on the canvas, and will have updated values based on the
     *               network table record with the key @param key
     */
    public Data(String key, Widget widget) {
        this.key = key;
        this.widget = widget;
    }

    /**
     * Accessor for key.
     *
     * @return The data's key
     */
    public String getKey() {
        return key;
    }

    /**
     * Accessor for widget.
     *
     * @return The data's widget
     */
    public Widget getWidget() {
        return widget;
    }

    /**
     * Update the values of the data based on the update mechanisms of the widget; generally, the value will be updated
     * based on values read from the network table that the application is connected to.
     */
    public void update() {
        widget.update(key);
    }

}
