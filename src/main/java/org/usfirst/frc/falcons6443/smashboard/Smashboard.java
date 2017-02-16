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
        NetworkTable.setIPAddress("10.64.43.62");
        NetworkTable table = NetworkTable.getTable("smashboard");

        JPanel panel = new JPanel();
        JProgressBar left = new JProgressBar();
        JProgressBar right = new JProgressBar();
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

            left.setValue((int) leftVal);
            right.setValue((int) rightVal);
        }
    }

    public static void main(String[] args) {
        Smashboard ex = new Smashboard();
    }
 
}
