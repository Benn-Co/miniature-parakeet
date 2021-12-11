package org.netlib.util;

import java.util.Vector;

/**
 * This class represents array arguments to I/O calls. For example, if you pass
 * an array to WRITE() in Fortran and the format specifies to print multiple
 * values, they'll be pulled from the array as appropriate. Here, we just pull
 * all the array elements into the I/O vector.
 * <p>
 * This file is part of the Fortran-to-Java (f2j) system, developed at the
 * University of Tennessee.
 * <p>
 * 
 * @author Keith Seymour (seymour@cs.utk.edu)
 */
public final class ArraySpec {

    private final Vector<Object> vec;

    /**
     * Create a new ArraySpec for an integer array.
     *
     * @param arr
     *            The array to be used in the I/O call
     * @param off
     *            The offset into the array (i.e. the start point)
     * @param len
     *            The number of elements to copy from the array to the I/O
     *            vector.
     */
    public ArraySpec(int[] arr, int off, int len) {
        vec = new Vector<Object>();

        for (int i = off; i < off + len; i++) {
            vec.addElement(Integer.valueOf(arr[i]));
        }
    }

    /**
     * Create a new ArraySpec for a double precision array.
     *
     * @param arr
     *            The array to be used in the I/O call
     * @param off
     *            The offset into the array (i.e. the start point)
     * @param len
     *            The number of elements to copy from the array to the I/O
     *            vector.
     */
    public ArraySpec(double[] arr, int off, int len) {
        vec = new Vector<Object>();

        for (int i = off; i < off + len; i++) {
            vec.addElement(Double.valueOf(arr[i]));
        }
    }

    /**
     * Create a new ArraySpec for a float array.
     *
     * @param arr
     *            The array to be used in the I/O call
     * @param off
     *            The offset into the array (i.e. the start point)
     * @param len
     *            The number of elements to copy from the array to the I/O
     *            vector.
     */
    public ArraySpec(float[] arr, int off, int len) {
        vec = new Vector<Object>();

        for (int i = off; i < off + len; i++) {
            vec.addElement(Float.valueOf(arr[i]));
        }
    }

    /**
     * Create a new ArraySpec for a String array.
     *
     * @param arr
     *            The array to be used in the I/O call
     * @param off
     *            The offset into the array (i.e. the start point)
     * @param len
     *            The number of elements to copy from the array to the I/O
     *            vector.
     */
    public ArraySpec(String[] arr, int off, int len) {
        vec = new Vector<Object>();

        for (int i = off; i < off + len; i++) {
            vec.addElement(arr[i]);
        }
    }

    /**
     * Create a new ArraySpec for a String (not array). Here the String is not
     * an array, but we want to pull out the characters individually.
     *
     * @param str
     *            The string to be used in the I/O call
     */
    public ArraySpec(String str) {
        char[] chars = str.toCharArray();
        vec = new Vector<Object>();

        for (int i = 0; i < chars.length; i++) {
            vec.addElement(String.valueOf(chars[i]));
        }
    }

    /**
     * Gets the I/O vector for this ArraySpec.
     *
     * @return the Vector representation of the ArraySpec.
     */
    public Vector<Object> get_vec() {
        return vec;
    }
}
