package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.falcons6443.smashboard.Smashboard;
import org.usfirst.frc.falcons6443.smashboard.utilities.ColorUtils;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * @author Shivashriganesh Mahato
 */
public class SpeedBar extends Widget {

    private float xzz = 0.0f;
    private boolean isFlipped;
    private Color initClr, terminalClr, lerpedClr;
    private int barHeight;

    public SpeedBar(NetworkTable nTable, String barSprite, int x, int y, int width, int height, boolean isFlipped,
                    Color initClr, Color terminalClr) {
        super(nTable, barSprite, x, y, width, height);
        this.isFlipped = isFlipped;
        this.initClr = initClr;
        this.terminalClr = terminalClr;
        this.lerpedClr = initClr;
        barHeight = 0;
    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {
        g.setColor(lerpedClr);
        if (!isFlipped)
            g.fillRect(x - 1, (Smashboard.Height - barHeight), width, barHeight);
        else
            g.fillRect(x - (Math.abs(width) - 1), (Smashboard.Height - barHeight), Math.abs(width), barHeight);
        g.drawImage(sprite, x, y, width, height, observer);
    }

    @Override
    public void update(String key) {
//        barHeight = (int) ((nTable.getNumber(key, 0.0) / 100) * height);
        barHeight = (int) ((xzz / 100) * height);
        xzz = (xzz + 1.0f) % 100.0f;
        lerpedClr = ColorUtils.lerpColor(initClr, terminalClr, xzz / 100);
    }

}
