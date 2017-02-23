package org.usfirst.frc.falcons6443.smashboard;

import org.usfirst.frc.falcons6443.smashboard.widgets.*;
import org.usfirst.frc.falcons6443.smashboard.widgets.Label;

import java.awt.*;

/**
 * The main class that defines the Smashboard application properties and updates the components
 *
 * @author Shivashriganesh Mahato
 */
public class Smashboard {

    // Global constants
    public static final int Width = 853;
    public static final int Height = 640;

    private final Color TriggerInitClr = new Color(76, 205, 55);
    private final Color TriggerTermClr = new Color(236, 31, 40);
    private final int InterpDegree = 4;

    // The smashboard application itself
    private Dashboard smashboard;

    /**
     * Construct the Smashboard with parameters to initialize the Dashboard
     *
     * @param ipAddress   The IP Address of the RoboRIO (where the wanted NetworkTables are stored) to connect to
     * @param nTableKey   The name of the NetworkTable to retrieve data from (if it doesn't exist already, it will be
     *                    created here)
     * @param title       The title of the application (will be displayed in the menu bar)
     * @param bgColor     The background color of the application
     * @param isResizable Should the user be allowed to resize the application?
     * @param width       The width of the application
     * @param height      The height of the application
     */
    private Smashboard(String ipAddress, String nTableKey, String title, Color bgColor, boolean isResizable, int width,
                       int height) {
        smashboard = new Dashboard(ipAddress, nTableKey, title, bgColor, isResizable, width, height);
    }

    /**
     * Initialize the Smashboard with the data values and images that should be displayed
     */
    private void init() {
        // Add the data and images needed in the application to the smashboard
        smashboard.addSImage("/img/Banner.png", 0, 0, Width, 153);
        smashboard.addSImage("/img/SpeedBarLeftScale.png", 0, 174, 177, 466);
        smashboard.addSImage("/img/SpeedBarRightScale.png", Width - 177, 174, 177, 466);
        smashboard.addData("leftTriggerVal",
                new SpeedBar(smashboard.getNTable(), "/img/SpeedBar.png", 44, 205, 133,
                        435, false, TriggerInitClr, TriggerTermClr, InterpDegree));
        smashboard.addData("rightTriggerVal",
                new SpeedBar(smashboard.getNTable(), "/img/SpeedBar.png", Width - 44, 205, -133,
                        435, true, TriggerInitClr, TriggerTermClr, InterpDegree));
        smashboard.addSImage("/img/CompassBack.png", (Width / 2 - 78), 200, 156, 156);
        smashboard.addData("robotHeadingVal",
                new Compass(smashboard.getNTable(), "/img/CompassNeedle.png", (Width / 2 -  15), 200,
                        30, 154, 0));
        smashboard.addData("transmissionLevel",
                new Label(smashboard.getNTable(), 200, 50, 50, 50, Color.WHITE, null, ""));
        smashboard.addSImage("/img/CompassMiddle.png", (Width / 2 - 18), 260, 36, 36);

        // Initialize the smashboard's properties
        smashboard.init();
        // Run the smashboard application
        smashboard.run();
    }

    /**
     * Run a loop that will update the data
     */
    private void loop() {
        // Update loop
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Update the properties of the data continuously
            smashboard.update();
        }
    }

    /**
     * Run the application
     */
    public static void main(String[] args) {
        // Initialize and run the main Smashboard instance
        Smashboard mySmashboard = new Smashboard("10.64.43.62", "smashboard", "Smashboard",
                Color.BLACK, false, Width, Height);
        mySmashboard.init();
        mySmashboard.loop();
    }

}
