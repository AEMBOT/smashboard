package org.usfirst.frc.falcons6443.smashboard;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Shivashriganesh Mahato
 */
public class Smashboard extends JFrame {

    public Smashboard() {
        NetworkTable.setClientMode();
        NetworkTable.setIPAddress("10.64.43.27");
        NetworkTable table = NetworkTable.getTable("smashboard");

        JPanel panel = new JPanel();
        JLabel left = new JLabel("");
        JLabel right = new JLabel("");
        panel.add(left);
        panel.add(right);
        add(panel);

        setTitle("Smashboard");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);

        double leftVal, rightVal;

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Smashboard.class.getName()).log(Level.SEVERE, null, ex);
            }

            leftVal = table.getNumber("right", 0.0);
            rightVal = table.getNumber("left", 0.0);

            left.setText(String.valueOf(leftVal));
            right.setText(String.valueOf(rightVal));
        }
    }

    public static void main(String[] args) {
        Smashboard ex = new Smashboard();
    }
 
}
