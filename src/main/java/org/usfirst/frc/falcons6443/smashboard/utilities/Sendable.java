package org.usfirst.frc.falcons6443.smashboard.utilities;

/**
 * @author Shivashriganesh Mahato
 */
public enum Sendable {
    COMMAND("Command");

    private String name;

    private Sendable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
