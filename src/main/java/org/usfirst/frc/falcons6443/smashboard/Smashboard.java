package org.usfirst.frc.falcons6443.smashboard;

import org.usfirst.frc.falcons6443.smashboard.widgets.SpeedBar;

import java.awt.*;

/**
 * @author Shivashriganesh Mahato
 */
public class Smashboard {

    public static final int Width = 853;
    public static final int Height = 640;

    private final Color TriggerInitClr = new Color(76, 205, 55);
    private final Color TriggerTermClr = new Color(236, 31, 40);
    private Dashboard smashboard;

    private Smashboard(String ipAddress, String nTableKey, String title, Color bgColor, boolean isResizable, int width,
                       int height) {
        smashboard = new Dashboard(ipAddress, nTableKey, title, bgColor, isResizable, width, height);
    }

    private void init() {
        smashboard.addSImage("/img/Banner.png", 0, 0, Width, 100);
        smashboard.addData("left",
                new SpeedBar(smashboard.getNTable(), "/img/SpeedBar.png", 0, 140, 75,
                        500, false, TriggerInitClr, TriggerTermClr));
        smashboard.addData("right",
                new SpeedBar(smashboard.getNTable(), "/img/SpeedBar.png", Width, 140, -75,
                        500, true, TriggerInitClr, TriggerTermClr));
        smashboard.init();
        smashboard.run();
    }

    private void loop() {
        while (true) {
            smashboard.update();
        }
    }

    public static void main(String[] args) {
        Smashboard mySmashboard = new Smashboard("10.64.43.62", "smashboard", "Smashboard",
                Color.BLACK, false, Width, Height);
        mySmashboard.init();
        mySmashboard.loop();
    }
 
}
