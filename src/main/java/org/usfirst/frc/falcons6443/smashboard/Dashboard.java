package org.usfirst.frc.falcons6443.smashboard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

    public void init() {
        this.add(panel);
    }

    public void update(ArrayList<Data> components) {
        for (Data data : components) {
            if (!data.getIsAddedToDB()) {
                panel.add(data.getWidget());
                data.setAddedToDB();
            }
        }
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
