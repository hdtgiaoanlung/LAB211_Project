/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author khang
 */
public class ArrayUtils {

    public static int[] getRandomArray(int length, int min, int max) {
        int[] ret = new int[length];
        for (int i = 0; i < length; i++) {
            ret[i] = NumberUtils.getRandomNumberInRange(min, max);
        }
        return ret;
    }

    public static void displayIntArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] cloneArray(int[] arr) {
        int[] ret = new int[arr.length];
        int c = 0;
        for (int i : arr) {
            ret[c++] = i;
        }
        return ret;
    }
}
