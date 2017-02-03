package org.usfirst.frc.falcons6443.smashboard;

import javax.swing.*;

/**
 * @author Shivashriganesh Mahato
 */
public class Data {

    private String name;
    private JProgressBar widget;

    public Data(String name) {
        this.name = name;
        this.widget = new JProgressBar();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JProgressBar getWidget() {
        return this.widget;
    }

    public int getWidgetVal() {
        return this.widget.getValue();
    }

    public void setWidgetVal(int val) {
        this.widget.setValue(val);
    }
}
