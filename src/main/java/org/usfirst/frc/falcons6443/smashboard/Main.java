package org.usfirst.frc.falcons6443.smashboard;

/**
 * @author Shivashriganesh Mahato
 */
public class Main {

    public static SmashBoard smashBoard = SmashBoard.getInstance();

    public static void main(String[] args) {
        smashBoard.init("Smashboard", 640, 480, "Meme", "");
        smashBoard.run();

        smashBoard.runLoop();
    }

}
