package org.usfirst.frc.falcons6443.smashboard;

import org.usfirst.frc.falcons6443.smashboard.widgets.Widget;

/**
 * @author Shivashriganesh Mahato
 */
public class Data {

    private String key;
    private Widget widget;

    public<T extends Widget> Data(String key, Class<T> widgetClass) {
        this.key = key;
        try {
            widget = widgetClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public String getKey() {
        return key;
    }

    public Widget getWidget() {
        return widget;
    }
}
