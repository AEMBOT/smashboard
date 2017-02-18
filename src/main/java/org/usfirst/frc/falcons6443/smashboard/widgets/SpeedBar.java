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

    public SpeedBar(NetworkTable nTable, String barSprite, int x, int y, int width, int height, boolean isFlipped,
                    Color initClr, Color terminalClr) {
        super(nTable, barSprite, x, y, width, height);
        this.isFlipped = isFlipped;
        this.initClr = initClr;
        this.terminalClr = terminalClr;
        this.lerpedClr = initClr;
    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {
        g.setColor(lerpedClr);
        if (!isFlipped)
            g.fillRect(x - 1, y, width, height);
        else
            g.fillRect(x - (Math.abs(width) - 1), y, Math.abs(width), height);
        super.paint(g, observer);
    }

    @Override
    public void update(String key) {
        height = (int) nTable.getNumber(key, 0.0);
        lerpedClr = ColorUtils.lerpColors(initClr, terminalClr, height / 640.0f);
    }

}
