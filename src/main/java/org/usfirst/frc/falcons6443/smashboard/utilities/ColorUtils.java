package org.usfirst.frc.falcons6443.smashboard.utilities;

import java.awt.*;

/**
 * @author Shivashriganesh Mahato
 */
public class ColorUtils {

    public static int lerp(float v0, float v1, float t) {
        return (int) ((1 - t) * v0 + t * v1);
    }

    public static Color lerpColor(Color initClr, Color termClr, float val) {
        return new Color(
                constrain(lerp(initClr.getRed(), termClr.getRed(), val), 0, 255),
                constrain(lerp(initClr.getGreen(), termClr.getGreen(), val), 0, 255),
                constrain(lerp(initClr.getBlue(), termClr.getBlue(), val), 0, 255),
                constrain(lerp(initClr.getAlpha(), termClr.getAlpha(), val), 0, 255)
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
