package org.usfirst.frc.falcons6443.smashboard;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 * @author Shivashriganesh Mahato
 */
public class Smashboard {
	
	public static void main(String args[]) {
		JFrame frame = new JFrame("JFrame Example");
        JPanel panel = new JPanel();
        JProgressBar pBar = new JProgressBar();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("This is a label!"); 

        JButton button = new JButton();
        button.setText("Press me"); 

        panel.add(label);
        panel.add(button); 

        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	          pBar.setValue(50);
	        }
	      });
	}
	
}
