package org.usfirst.frc.falcons6443.smashboard.widgets;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * @author Shivashriganesh Mahato
 */
public class Label extends Widget {

    private String lName;
    private String value;
    private Color color;
    private Font font;

    public Label(NetworkTable nTable, String spritePath, int x, int y, int width, int height, Color color,
                 Font font, String value) {
        super(nTable, spritePath, x, y, width, height);
        this.color = color;
        this.font = font;
        this.value = value;
        lName = "";
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {
        if (font != null)
            g.setFont(font);
        g.setColor(color);
        g.drawString(lName + ": " + value, x, y);
    }

    @Override
    public void update(String key) {
        lName = key;
        if (nTable != null)
            value = nTable.getValue(key, null).toString();
    }

}
