package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.falcons6443.smashboard.utilities.StaticImage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;

/**
 * @author Patrick Higgins
 */
public class NumberChooser extends Widget {

    private StaticImage up, down;
    private int num;
    private String label, description;

    /**
     * Construct the Widget with its properties.
     *
     * @param nTable     The network table that the application is talking to
     */
    public NumberChooser(NetworkTable nTable, String label, String description, StaticImage up, StaticImage down) {
        super(nTable, "", 0, 0, 0, 0);
        this.label = label;
        this.description = description;
        this.up = up;
        this.down = down;
    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {
        g.setFont(g.getFont().deriveFont(12.0f));
        g.setColor(Color.WHITE);
        g.drawString(label, up.getX() + 20, up.getY() - 25);
        g.drawString(description, up.getX() - 40, up.getY() - 5);
        up.paint(g, observer);
        g.setFont(g.getFont().deriveFont(40.0f));
        g.setColor(new Color(150, 150, 150));
        g.drawString(Integer.toString(num + 1),
                up.getX() + (Integer.toString(num + 1).length() == 1 ? 42 : 27),
                up.getY() + up.getHeight() - 11);
        g.drawString(Integer.toString(num - 1),
                up.getX() + (Integer.toString(num - 1).length() == 1 ? 42 : 27),
                up.getY() + up.getHeight() + 109);
        g.setColor(Color.WHITE);
        g.setFont(g.getFont().deriveFont(70.0f));
        g.drawString(Integer.toString(num),
                up.getX() + (Integer.toString(num).length() == 1 ? 35 : 10),
                up.getY() + up.getHeight() + 60);
        down.paint(g, observer);
    }

    @Override
    public void update(String key) {
        nTable.putNumber(key, num);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int mouseX = mouseEvent.getX(), mouseY = mouseEvent.getY();
        if (mouseX > up.getX() && mouseY > up.getY() &&
                mouseX < up.getX() + up.getWidth() &&
                mouseY < up.getY() + up.getHeight()) {
            num++;
        }
        if (mouseX > down.getX() && mouseY > down.getY() &&
                mouseX < down.getX() + down.getWidth() &&
                mouseY < down.getY() + down.getHeight()) {
            num--;
        }
    }

}
