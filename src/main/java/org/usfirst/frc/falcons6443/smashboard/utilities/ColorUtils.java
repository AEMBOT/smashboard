package org.usfirst.frc.falcons6443.smashboard.utilities;

import java.awt.*;

/**
 * @author Shivashriganesh Mahato
 */
public class ColorUtils {

    public static int interpolate(float v0, float v1, float t, int degree) {
        return (int) ((1 - t) * v0 + Math.pow(t, 4) * v1);
    }

    public static Color colorInterp(Color initClr, Color termClr, float val, int degree) {
        return new Color(
                constrain(interpolate(initClr.getRed(), termClr.getRed(), val, degree), 0, 255),
                constrain(interpolate(initClr.getGreen(), termClr.getGreen(), val, degree), 0, 255),
                constrain(interpolate(initClr.getBlue(), termClr.getBlue(), val, degree), 0, 255),
                constrain(interpolate(initClr.getAlpha(), termClr.getAlpha(), val, degree), 0, 255)
        );
    }

    public static <T extends Number & Comparable<T>> T constrain(T value, T min, T max) {
        if (value.compareTo(min) < 0)
            return min;
        if (value.compareTo(max) > 0)
            return max;
        return value;
    }

}
