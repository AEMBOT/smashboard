package org.usfirst.frc.falcons6443.smashboard.utilities;

import java.awt.*;

/**
 * @author Shivashriganesh Mahato
 */
public class ColorUtils {

    public static Color lerpColors(Color initClr, Color termClr, float proportion) {
        return new Color(
                constrain((initClr.getRed() + (termClr.getRed() - initClr.getRed()) * proportion), 0.0f, 255.0f),
                constrain((initClr.getGreen() + (termClr.getGreen() - initClr.getGreen()) * proportion), 0.0f, 255.0f),
                constrain((initClr.getBlue() + (termClr.getBlue() - initClr.getBlue()) * proportion), 0.0f, 255.0f),
                constrain((initClr.getAlpha() + (termClr.getAlpha() - initClr.getAlpha()) * proportion), 0.0f, 255.0f)
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
