package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.falcons6443.smashboard.utilities.StaticImage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;

/**
 * Created by higgp153 on 3/25/2017.
 */
public class NumberChooser extends Widget {
    private StaticImage up, down;
    private int time;

    /**
     * Construct the Widget with its properties.
     *
     * @param nTable     The network table that the application is talking to
     */
    public NumberChooser(NetworkTable nTable, StaticImage up, StaticImage down) {
        super(nTable, "", 0, 0, 0, 0);
        this.up = up;
        this.down = down;
    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {
        up.paint(g, observer);
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(time), up.getX() + 50, up.getY() + up.getHeight() + 25);
        down.paint(g, observer);
    }

    @Override
    public void update(String key) {
        nTable.putNumber(key, time);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int mouseX = mouseEvent.getX(), mouseY = mouseEvent.getY();
        if (mouseX > up.getX() && mouseY > up.getY() &&
                mouseX < up.getX() + up.getWidth() &&
                mouseY < up.getY() + up.getHeight()) {
            time++;
        }
        if (mouseX > down.getX() && mouseY > down.getY() &&
                mouseX < down.getX() + down.getWidth() &&
                mouseY < down.getY() + down.getHeight()) {
            time--;
        }
    }
}
