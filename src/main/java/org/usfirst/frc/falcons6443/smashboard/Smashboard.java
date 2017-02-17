package org.usfirst.frc.falcons6443.smashboard;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

import javax.swing.*;
import java.awt.*;

/**
 * @author Shivashriganesh Mahato
 */
public class Smashboard extends JFrame {

    public Smashboard() {
        NetworkTable.setClientMode();
        NetworkTable.setIPAddress("10.64.43.62");
        NetworkTable table = NetworkTable.getTable("smashboard");

        Canvas panel = new Canvas();
        panel.setBackground(Color.BLACK);
        add(panel);

        setTitle("Smashboard");
        getContentPane().setBackground(Color.black);
        setResizable(false);
        setSize(853, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);

        double leftVal, rightVal;

        while (true) {
            leftVal = table.getNumber("right", 0.0);
            rightVal = table.getNumber("left", 0.0);

            panel.setLeftVal((int) leftVal);

            panel.repaint();
        }
    }

    public static void main(String[] args) {
        Smashboard ex = new Smashboard();
    }
 
}
