package org.usfirst.frc.falcons6443.smashboard;

import javax.swing.*;

/**
 * @author Shivashriganesh Mahato
 */
public class Data {

    private String name;
    private JProgressBar widget;
    private int value;
    private boolean isAddedToDB;

    public Data(String name, int value) {
        this.name = name;
        this.widget = new JProgressBar();
        this.widget.setValue(0);
        this.isAddedToDB = false;
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

    public void setAddedToDB() {
        this.isAddedToDB = true;
    }

    public boolean getIsAddedToDB() {
        return isAddedToDB;
    }

}
