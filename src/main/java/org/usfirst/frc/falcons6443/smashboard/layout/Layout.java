package org.usfirst.frc.falcons6443.smashboard.layout;

import org.usfirst.frc.falcons6443.smashboard.utilities.StaticImage;
import org.usfirst.frc.falcons6443.smashboard.widgets.Widget;

import java.util.ArrayList;

/**
 * Created by higgp153 on 3/13/2017.
 */
public class Layout {
    private ArrayList<Widget> widgets;
    private ArrayList<StaticImage> imgs;

    public Layout () {
        widgets = new ArrayList<Widget>();
        imgs = new ArrayList<StaticImage>();
    }

    public void addWidget (Widget widget) {
        widgets.add(widget);
    }

    public void addImage (StaticImage img) {
        imgs.add(img);
    }


}
