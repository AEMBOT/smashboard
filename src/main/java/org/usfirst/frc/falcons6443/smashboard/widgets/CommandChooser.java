package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.IOException;

/**
 * @author Shivashriganesh Mahato
 */
public class CommandChooser extends Widget {

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
     */
    public CommandChooser(NetworkTable nTable, String spritePath, int x, int y,
                          String label, Color labelClr, String optionSpritePath) {
        super(nTable, spritePath, x, y, 156, 36);
        try {
            optionSprite = ImageIO.read(this.getClass().getResource(optionSpritePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.label = label;
        this.labelClr = labelClr;
        options = new String[50];
        defaultTxt = "";
        menuOpen = false;
        selected = -1;
    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {
        g.setColor(labelClr);
        g.drawString(label, x, y);
        g.drawImage(sprite, x, y + 10, width, height, observer);
        g.drawString(selected == -1 ? defaultTxt : options[selected], x + 50, y + 30);
        if (menuOpen)
            for (int op = 0; op < options.length; op++) {
                g.drawImage(optionSprite, x, (y + 10 + height + (op * height)), width, height, observer);
                g.setColor(Color.BLACK);
                g.drawString(options[op], x + 10, (y + 10 + height + (op * height)) + 20);
            }
    }

    @Override
    public void update(String key) {
        defaultTxt = nTable.getString(key + "Default", "");
        options = nTable.getStringArray(key + "Options", new String[]{"UNDEFINED"});
        if (selected != -1)
            nTable.putString(key, options[selected]);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        double mouseX = mouseEvent.getX(), mouseY = mouseEvent.getY();
        if (mouseX >= x && mouseX <= (x + width)) {
            if (mouseY >= (y + 10) && mouseY <= (y + height + 10))
                menuOpen = !menuOpen;
            if (menuOpen && mouseY >= (y + 10 + height) && mouseY <= (y + height + 10 + (height * options.length))) {
                selected = (int) ((mouseY - (y + 10 + height)) / height);
                menuOpen = false;
            }
        }
        if (menuOpen && !(mouseX >= x && mouseX <= (x + width) && mouseY >= (y + 10) &&
                mouseY <= (y + height + 10 + (height * options.length))))
            menuOpen = false;

    }

    public String getDefaultTxt() {
        return defaultTxt;
    }

    public void setDefaultTxt(String defaultTxt) {
        this.defaultTxt = defaultTxt;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Color getLabelClr() {
        return labelClr;
    }

    public void setLabelClr(Color labelClr) {
        this.labelClr = labelClr;
    }

    public Image getOptionSprite() {
        return optionSprite;
    }

    public String[] getOptions() {
        return options;
    }

    public int getSelected() {
        return selected;
    }

    public boolean isMenuOpen() {
        return menuOpen;
    }
}
