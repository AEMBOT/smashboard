package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.falcons6443.smashboard.utilities.Sendable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.IOException;

/**
 * @author Shivashriganesh Mahato
 */
public class SendableChooser extends Widget {

    private Image optionSprite;
    private String defaultTxt, label;
    private String[] options;
    private int selected;
    private boolean menuOpen;
    private Color labelClr;

    /**
     * Construct the Widget with its properties
     *
     * @param nTable     The network table that the application is talking to
     * @param spritePath The path of the sprite of the widget in the resources root; If equal to "", the sprite will be
     *                   initialized to null
     * @param x          The widget's x coordinate on the application's canvas
     * @param y          The widget's y coordinate on the application's canvas
     * @param width      The widget's width on the application's canvas
     * @param height     The widget's height on the application's canvas
     */
    public SendableChooser(NetworkTable nTable, String spritePath, int x, int y, int width, int height, Sendable type,
                           String label, String[] options, Color labelClr, String optionSpritePath) {
        super(nTable, spritePath, x, y, width, height);
        try {
            optionSprite = ImageIO.read(this.getClass().getResource(optionSpritePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.label = label;
        this.options = options;
        this.labelClr = labelClr;
        defaultTxt = type.getName();
        menuOpen = false;
    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {
        g.setColor(labelClr);
        g.drawString(label, x, y);
        g.drawImage(sprite, x, y + 10, width, height, observer);
        g.drawString(defaultTxt, x + 50, y + 30);
        if (menuOpen)
            for (int op = 0; op < options.length; op++) {
                g.drawImage(optionSprite, x, (y + 10 + height + (op * height)), width, height, observer);
                g.setColor(Color.BLACK);
                g.drawString(options[op], x + 10, (y + 10 + height + (op * height)) + 20);
            }
    }

    @Override
    public void update(String key) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        double mouseX = mouseEvent.getX(), mouseY = mouseEvent.getY() - 25;
        if (mouseX >= x && mouseX <= (x + width) && mouseY >= (y + 10) && mouseY <= (y + height + 10)) {
            menuOpen = !menuOpen;
        }
    }
}
