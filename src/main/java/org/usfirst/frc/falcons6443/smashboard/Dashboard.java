package org.usfirst.frc.falcons6443.smashboard;

import javax.swing.*;
import java.awt.*;

/**
 * @author Shivashriganesh Mahato
 */
public class Dashboard extends JFrame {

    private JPanel panel;

    public Dashboard(String title) {
        super(title);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
    }

    public JPanel getPanel() {
        return panel;
    }

    public void update() {
        this.add(panel);
    }

    public void display(int width, int height, int operation) {
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(operation);
        this.setVisible(true);
    }

    public void display(int width, int height) {
        display(width, height, WindowConstants.EXIT_ON_CLOSE);
    }

}
