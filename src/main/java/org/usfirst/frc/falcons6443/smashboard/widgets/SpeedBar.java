package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.falcons6443.smashboard.utilities.ColorUtils;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * @author Shivashriganesh Mahato
 */
public class SpeedBar extends Widget {

    private boolean isFlipped;
    private Color initClr, terminalClr, lerpedClr;
    private int barHeight;
    private int interpDegree;

    public SpeedBar(NetworkTable nTable, String barSprite, int x, int y, int width, int height, boolean isFlipped,
                    Color initClr, Color terminalClr, int interpDegree) {
        super(nTable, barSprite, x, y, width, height);
        this.isFlipped = isFlipped;
        this.initClr = initClr;
        this.terminalClr = terminalClr;
        this.lerpedClr = initClr;
        this.interpDegree = interpDegree;
        barHeight = 0;
    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {
        g.setColor(lerpedClr);
        if (!isFlipped)
            g.fillRect(x, ((y + height) - barHeight), width, barHeight);
        else
            g.fillRect(x - Math.abs(width), ((y + height) - barHeight), Math.abs(width), barHeight);
        g.drawImage(sprite, x, y, width, height, observer);
    }

    @Override
    public void update(String key) {
        barHeight = (int) ((nTable.getNumber(key, 0.0) / 100) * height);
        lerpedClr = ColorUtils.colorInterp(initClr, terminalClr,
                (float) ((nTable.getNumber(key, 0.0) / 100)), interpDegree);
    }

}
