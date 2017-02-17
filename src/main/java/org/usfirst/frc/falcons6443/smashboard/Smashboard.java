package org.usfirst.frc.falcons6443.smashboard;

import org.usfirst.frc.falcons6443.smashboard.widgets.Widget;

import java.awt.*;

/**
 * @author Shivashriganesh Mahato
 */
public class Smashboard {

    private Dashboard smashboard;

    private Smashboard(String ipAddress, String nTableKey, String title, Color bgColor, boolean isResizable, int width,
                       int height) {
        smashboard = new Dashboard(ipAddress, nTableKey, title, bgColor, isResizable, width, height);
    }

//    public Smashboard() {
//        NetworkTable.setClientMode();
//        NetworkTable.setIPAddress("10.64.43.62");
//        NetworkTable table = NetworkTable.getTable("smashboard");
//
//        Canvas panel = new Canvas();
//        panel.setBackground(Color.BLACK);
//        add(panel);
//
//        setTitle("Smashboard");
//        getContentPane().setBackground(Color.black);
//        setResizable(false);
//        setSize(853, 640);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//        setVisible(true);
//
//        double leftVal, rightVal;
//
//        while (true) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            leftVal = table.getNumber("right", 0.0);
//            rightVal = table.getNumber("left", 0.0);
//
//            panel.setLeftVal((int) leftVal);
//
//            panel.repaint();
//        }
//    }
//

    private void init() {
        smashboard.addData("leftVal", Widget.class);
        smashboard.init();
        smashboard.run();
    }

    private void loop() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            smashboard.update();
        }
    }

    public static void main(String[] args) {
        Smashboard mySmashboard = new Smashboard("10.64.43.62", "smashboard", "Smashboard",
                Color.BLACK, false, 853, 640);
        mySmashboard.init();
        mySmashboard.loop();
    }
 
}
