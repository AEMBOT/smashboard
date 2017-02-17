package org.usfirst.frc.falcons6443.smashboard;

import org.usfirst.frc.falcons6443.smashboard.widgets.Widget;

/**
 * @author Shivashriganesh Mahato
 */
public class Data {

    private String key;
    private Widget widget;

    public Data(String key, Widget widget) {
        this.key = key;
        this.widget = widget;
    }

    public String getKey() {
        return key;
    }

    public Widget getWidget() {
        return widget;
    }
}
