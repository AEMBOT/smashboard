package org.usfirst.frc.falcons6443.smashboard.widgets;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.falcons6443.smashboard.utilities.StaticImage;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * A widget that displays the driving direction. This is either forward and reverse. Sprites for each state are drawn,
 * and the appropriate one is covered to represent inactivity of the state (reverse covered if forward, forward covered
 * if reversed).
 *
 * @author Shivashriganesh Mahato
 */
public class DriveDirection extends Widget {

    private StaticImage forwardSprite, reverseSprite;
    private boolean reversed;

    /**
     * Construct the Widget with its properties.
     *
     * @param nTable        The network table that the application is talking to
     * @param forwardSprite The sprite indicating a forward state
     * @param reverseSprite The sprite indicating a reverse state
     */
    public DriveDirection(NetworkTable nTable, StaticImage forwardSprite, StaticImage reverseSprite) {
        super(nTable, "", 0, 0, 0, 0);
        this.forwardSprite = forwardSprite;
        this.reverseSprite = reverseSprite;
        reversed = false;
    }

    /**
     * Paint the forward and reverse state sprites. Depending on the state, a rectangle is painted over the respective
     * sprite to indicate that that state is not active.
     * If the state is forward, the reverse sprite is covered.
     * If the state is reversed, the forward sprite is covered.
     *
     * @param g        The Graphics object to draw this widget on
     * @param observer The asynchronous update interface that receives notifications about Image information as the
     */
    @Override
    public void paint(Graphics g, ImageObserver observer) {
        forwardSprite.paint(g, observer);
        reverseSprite.paint(g, observer);
        g.setColor(new Color(0, 0, 0, 210));
        if (!reversed)
            g.fillRect(reverseSprite.getX(), reverseSprite.getY(), reverseSprite.getWidth(), reverseSprite.getHeight());
        else
            g.fillRect(forwardSprite.getX(), forwardSprite.getY(), forwardSprite.getWidth(), forwardSprite.getHeight());
    }

    /**
     * Update the direction state (forward/reverse, with a reversed flag).
     *
     * @param key The key of the data that this widget belongs to, and of the record that will be read to find the
     */
    @Override
    public void update(String key) {
        reversed = nTable.getBoolean(key, false);
    }

    /**
     * Accessor for reversed.
     *
     * @return Is the robot in reversed mode?
     */
    public boolean isReversed() {
        return reversed;
    }
    
}
