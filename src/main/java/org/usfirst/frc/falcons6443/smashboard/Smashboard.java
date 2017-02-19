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
    private final int InterpDegree = 4;

    private Dashboard smashboard;

    private Smashboard(String ipAddress, String nTableKey, String title, Color bgColor, boolean isResizable, int width,
                       int height) {
        smashboard = new Dashboard(ipAddress, nTableKey, title, bgColor, isResizable, width, height);
    }

    private void init() {
        smashboard.addSImage("/img/Banner.png", 0, 0, Width, 153);
        smashboard.addSImage("/img/SpeedBarLeftScale.png", 0, 174, 177, 466);
        smashboard.addSImage("/img/SpeedBarRightScale.png", Width - 177, 174, 177, 466);
        smashboard.addData("leftTriggerVal",
                new SpeedBar(smashboard.getNTable(), "/img/SpeedBar.png", 44, 205, 133,
                        435, false, TriggerInitClr, TriggerTermClr, InterpDegree));
        smashboard.addData("rightTriggerVal",
                new SpeedBar(smashboard.getNTable(), "/img/SpeedBar.png", Width - 44, 205, -133,
                        435, true, TriggerInitClr, TriggerTermClr, InterpDegree));
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
