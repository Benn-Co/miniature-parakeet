package org.netlib.util;

import java.util.Vector;

/**
 * Implementations of various Fortran intrinsic functions.
 * <p>
 * This file is part of the Fortran-to-Java (f2j) system, developed at the
 * University of Tennessee.
 * <p>
 * This class contains various helper routines for f2j-generated code. These
 * routines are primarily implemented for handling Fortran intrinsic functions.
 * <p>
 * 
 * @author Keith Seymour (seymour@cs.utk.edu)
 */
public final class Util {

    public static double dsign(double d, double d1) {
        return d1 < 0.0D ? -Math.abs(d) : Math.abs(d);
    }

    public static int max(int i, int j, int k) {
        return Math.max(i <= j ? j : i, Math.max(j, k));
    }

    public static float max(float f, float f1, float f2) {
        return Math.max(f <= f1 ? f1 : f, Math.max(f1, f2));
    }

    public static double max(double d, double d1, double d2) {
        return Math.max(d <= d1 ? d1 : d, Math.max(d1, d2));
    }

    public static int min(int i, int j, int k) {
        return Math.min(i >= j ? j : i, Math.min(j, k));
    }

    public static float min(float f, float f1, float f2) {
        return Math.min(f >= f1 ? f1 : f, Math.min(f1, f2));
    }

    public static double min(double d, double d1, double d2) {
        return Math.min(d >= d1 ? d1 : d, Math.min(d1, d2));
    }

    public static double log10(double d) {
        return Math.log10(d);
    }

    public static float log10(float f) {
        return (float) Math.log10(f);
    }

    public static int nint(float f) {
        return (int) (f < 0.0F ? f - 0.5D : f + 0.5D);
    }

    /**
     * Fortran hyperbolic sine (SINH) intrinsic function.
     *
     * @param a
     *            the value to get the sine of
     *
     * @return the hyperbolic sine of a
     */
    public static double sinh(double a) {
        return Math.sinh(a);
    }

    /**
     * Fortran hyperbolic cosine (COSH) intrinsic function.
     *
     * @param a
     *            the value to get the cosine of
     *
     * @return the hyperbolic cosine of a
     */
    public static double cosh(double a) {
        return Math.cosh(a);
    }

    /**
     * Fortran hyperbolic tangent (TANH) intrinsic function.
     *
     * @param a
     *            the value to get the tangent of
     *
     * @return the hyperbolic tangent of a
     */
    public static double tanh(double a) {
        return Math.tanh(a);
    }

    /**
     * Fortran nearest integer (IDNINT) intrinsic function.
     * <p>
     * Returns:<br>
     * <ul>
     * <li>(int) (x+0.5), if x &gt;= 0
     * <li>(int) (x-0.5), if x &lt; 0
     * </ul>
     * 
     * @param x
     *            the double precision floating point value
     *
     * @return the nearest integer to x
     */
    public static int idnint(double x) {
        return (int) (x >= 0.0D ? x + 0.5D : x - 0.5D);
    }

    /**
     * Fortran floating point transfer of sign (SIGN) intrinsic function.
     * <p>
     * Returns:<br>
     * <ul>
     * <li>abs(a1), if a2 &gt;= 0
     * <li>-abs(a1), if a2 &lt; 0
     * </ul>
     *
     * @param a1
     *            floating point value
     * @param a2
     *            sign transfer indicator
     *
     * @return equivalent of Fortran SIGN(a1,a2) as described above.
     */
    public static float sign(float a1, float a2) {
        return a2 >= 0.0F ? Math.abs(a1) : -Math.abs(a1);
    }

    /**
     * Fortran integer transfer of sign (ISIGN) intrinsic function.
     * <p>
     * Returns:<br>
     * <ul>
     * <li>abs(a1), if a2 &gt;= 0
     * <li>-abs(a1), if a2 &lt; 0
     * </ul>
     *
     * @param a1
     *            integer value
     * @param a2
     *            sign transfer indicator
     *
     * @return equivalent of Fortran ISIGN(a1,a2) as described above.
     */
    public static int isign(int a1, int a2) {
        return a2 >= 0 ? Math.abs(a1) : -Math.abs(a1);
    }

    /**
     * Fortran floating point positive difference (DIM) intrinsic function.
     * <p>
     * Returns:<br>
     * <ul>
     * <li>a1 - a2, if a1 &gt; a2
     * <li>0, if a1 &lt;= a2
     * </ul>
     *
     * @param a1
     *            floating point value
     * @param a2
     *            floating point value
     *
     * @return equivalent of Fortran DIM(a1,a2) as described above.
     */
    public static float dim(float a1, float a2) {
        return a1 > a2 ? (a1 - a2) : 0.0F;
    }

    /**
     * Fortran integer positive difference (IDIM) intrinsic function.
     * <p>
     * Returns:<br>
     * <ul>
     * <li>a1 - a2, if a1 &gt; a2
     * <li>0, if a1 &lt;= a2
     * </ul>
     *
     * @param a1
     *            integer value
     * @param a2
     *            integer value
     *
     * @return equivalent of Fortran IDIM(a1,a2) as described above.
     */
    public static int idim(int a1, int a2) {
        return a1 > a2 ? (a1 - a2) : 0;
    }

    /**
     * Fortran double precision positive difference (DDIM) intrinsic function.
     * <p>
     * Returns:<br>
     * <ul>
     * <li>a1 - a2, if a1 &gt; a2
     * <li>0, if a1 &lt;= a2
     * </ul>
     *
     * @param a1
     *            double precision floating point value
     * @param a2
     *            double precision floating point value
     *
     * @return equivalent of Fortran DDIM(a1,a2) as described above.
     */
    public static double ddim(double a1, double a2) {
        return a1 > a2 ? (a1 - a2) : 0.0D;
    }

    public static String stringInsert(String s, String s1, int i, int j) {
        return new String(s.substring(0, i - 1) + s1.substring(0, (j - i) + 1) + s.substring(j, s.length()));
    }

    public static String stringInsert(String s, String s1, int i) {
        return stringInsert(s, s1, i, i);
    }

    public static String strCharAt(String s, int idx) {
        return String.valueOf(s.charAt(idx - 1));
    }

    public static int f77read(String fmt, Vector<?> v) {
        // stub
        return -1;
    }

    public static void f77write(String s, Vector<?> vector) {
        // stub
    }

    public static void f77write(Vector<?> vector) {
        // stub
    }

    public static void pause() {
        // stub
    }

    public static void pause(String msg) {
        // stub
    }
}
