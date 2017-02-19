package org.usfirst.frc.falcons6443.smashboard.utilities;

import java.awt.*;

/**
 * A set of global functions that can be used to manipulate color data
 *
 * @author Shivashriganesh Mahato
 */
public class ColorUtils {

    /**
     * Get the result of calculating a proportional value on an interpolate (two values, a min and max, are mapped so
     * the min is 0 and the max is 1, and the proportional value, between 0 and 1 is inputted to return the proportional
     * point on the interpolate. The equation can be edited through the degree, which, when increased, adds more of a
     * dip to the interpolate in the middle half. This dip determines how slow of an increase the interpolate has at the
     * beginning and then how rapid it becomes at the end. The higher the degree, the slower at the beginner and quicker
     * at the end.
     * <p>
     * Example - Linear interpolation for a red value of 2 colors:
     * Color A = RED
     * Color B = GREEN
     * So, v0 = 255 and v1 = 0 (because RED has a red value of 255 and green has a red value of 0)
     * Supposing we want to find the value in between, t = 0.5.
     * Because this is linear interpolation, degree = 1.
     * Passing these parameters into the method, 127 is returned (result is truncated to cast to int)
     *
     * @param v0     The minimum value of the interpolate
     * @param v1     The maximum value of the interpolate
     * @param t      The proportional value from 0 to 1
     * @param degree The degree to use in the equation
     * @return The calculated proportional point on the interpolate
     */
    public static int interpolate(float v0, float v1, float t, int degree) {
        return (int) ((1 - t) * v0 + Math.pow(t, degree) * v1);
    }

    /**
     * Interpolate a color between 2 colors initClr and termClr
     *
     * @param initClr The initial color of the interpolate
     * @param termClr The terminal color of the interpolate
     * @param val     The proportional value from 0 to 1
     * @param degree  The degree to use in the equation
     * @return The calculated proportional value on the interpolate (a color)
     */
    public static Color colorInterp(Color initClr, Color termClr, float val, int degree) {
        return new Color(
                constrain(interpolate(initClr.getRed(), termClr.getRed(), val, degree), 0, 255),
                constrain(interpolate(initClr.getGreen(), termClr.getGreen(), val, degree), 0, 255),
                constrain(interpolate(initClr.getBlue(), termClr.getBlue(), val, degree), 0, 255),
                constrain(interpolate(initClr.getAlpha(), termClr.getAlpha(), val, degree), 0, 255)
        );
    }

    /**
     * Get the result of constraining a value from min to max
     *
     * @param value The value to constrain
     * @param min   The minimum that the value can be
     * @param max   The maximum that the value can be
     * @param <T>   The type of the value (must be a Number that implements Comparable)
     * @return The constrained value
     */
    public static <T extends Number & Comparable<T>> T constrain(T value, T min, T max) {
        if (value.compareTo(min) < 0)
            return min;
        if (value.compareTo(max) > 0)
            return max;
        return value;
    }

}
