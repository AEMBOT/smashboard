package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.IOException;

/**
 * A widget that allows simple command choosing. A dropdown displays the different options, and selecting one updates
 * the command to be executed in the robot code accordingly.
 *
 * @author Shivashriganesh Mahato
 */
public class CommandChooser extends Widget {

    private Image optionSprite, downBar;
    private String defaultTxt, label;
    private String[] options;
    private int selected;
    private boolean menuOpen;
    private Color labelClr;

    /**
     * Construct the Widget with its properties.
     *
     * @param nTable           The network table that the application is talking to
     * @param spritePath       The path of the sprite of the widget in the resources root; If equal to "", the sprite will be
     *                         initialized to null
     * @param x                The widget's x coordinate on the application's canvas
     * @param y                The widget's y coordinate on the application's canvas
     * @param label            The widget's label (appears on top of the menu)
     * @param labelClr         The color for the widget's label
     * @param optionSpritePath The path of the background sprite for options
     */
    public CommandChooser(NetworkTable nTable, String spritePath, int x, int y,
                          String label, Color labelClr, String optionSpritePath, String downBarSpritePath) {
        super(nTable, spritePath, x, y, 156, 36);
        try {
            optionSprite = ImageIO.read(this.getClass().getResource(optionSpritePath));
            downBar = ImageIO.read(this.getClass().getResource(downBarSpritePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.label = label;
        this.labelClr = labelClr;
        options = new String[50];
        defaultTxt = "";
        menuOpen = false;
        selected = -1;
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    /**
     * Draw the command chooser: the name, the menu, and the options when it is open.
     *
     * @param g        The Graphics object to draw this widget on
     * @param observer The asynchronous update interface that receives notifications about Image information as the
     */
    @Override
    public void paint(Graphics g, ImageObserver observer) {
        g.setColor(labelClr);
        g.drawString(label, x, y);
        g.drawImage(menuOpen ? downBar : sprite, x, y + 10, width, height, observer);
        g.drawString(selected == -1 ? defaultTxt : options[selected], x + 50, y + 30);
        if (mousePosition.getX() > x && mousePosition.getX() < x + width && mousePosition.getY() > y + 10 &&
                mousePosition.getY() < y + 10 + height) {
            g.setColor(new Color(0, 0, 0, 50));
            g.fillRect(x, y + 10, width, height);
        }
        if (menuOpen) {
            for (int op = 0; op < options.length; op++) {
                g.drawImage(optionSprite, x, (y + 10 + height + (op * height)), width, height, observer);
                g.setColor(Color.WHITE);
                g.drawString(options[op], x + 10, (y + 10 + height + (op * height)) + 20);
                if (mousePosition.getX() > x && mousePosition.getX() < x + width &&
                        mousePosition.getY() > (y + 10 + height + (op * height)) &&
                        mousePosition.getY() < (y + 10 + height + (op * height)) + height) {
                    g.setColor(new Color(0, 0, 0, 50));
                    g.fillRect(x, (y + 10 + height + (op * height)), width, height);
                }
            }
        }
    }

    /**
     * Update the options and default text continuously in case they change somewhere in the robot code. Also push the
     * selected option to the network table so the robot code can use it.
     *
     * @param key The key of the data that this widget belongs to, and of the record that will be read to find the
     */
    @Override
    public void update(String key) {
        defaultTxt = nTable.getString(key + "Default", "");
        options = nTable.getStringArray(key + "Options", new String[]{"UNDEFINED"});
        if (selected != -1)
            nTable.putString(key, options[selected]);
    }

    /**
     * Update the closed/open status of the options list based on clicking on the menu and on the options while it is
     * open (clicking the menu toggles it, clicking an option closes it). Also, when an option is clicked, the selected
     * value is updated.
     *
     * @param mouseEvent Properties of the mouse at this event
     */
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

    /**
     * Accessor for defaultText.
     *
     * @return The default text that shows up in the menu when no option is selected
     */
    public String getDefaultTxt() {
        return defaultTxt;
    }

    /**
     * Mutator for defaultText.
     *
     * @param defaultTxt The new default text
     */
    public void setDefaultTxt(String defaultTxt) {
        this.defaultTxt = defaultTxt;
    }

    /**
     * Accessor for label.
     *
     * @return The text of the label that shows up on top of the menu
     */
    public String getLabel() {
        return label;
    }

    /**
     * Mutator for label.
     *
     * @param label The new label text
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Accessor for labelClr.
     *
     * @return The color of the label that shows up on top of the menu
     */
    public Color getLabelClr() {
        return labelClr;
    }

    /**
     * Mutator for labelClr.
     *
     * @param labelClr The new label color
     */
    public void setLabelClr(Color labelClr) {
        this.labelClr = labelClr;
    }

    /**
     * Accessor for optionSprite.
     *
     * @return The background sprite for options
     */
    public Image getOptionSprite() {
        return optionSprite;
    }

    /**
     * Accessor for options.
     *
     * @return The list of options
     */
    public String[] getOptions() {
        return options;
    }

    /**
     * Accessor for selected.
     *
     * @return The index of the selected option
     */
    public int getSelected() {
        return selected;
    }

    /**
     * Accessor for menuOpen.
     *
     * @return Is the menu open (and the options showing)?
     */
    public boolean isMenuOpen() {
        return menuOpen;
    }

}
