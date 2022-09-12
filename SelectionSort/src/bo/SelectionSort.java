/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import utils.ArrayUtils;
import utils.NumberUtils;

/**
 *
 * @author dinht
 */
public class SelectionSort {

    private int arr[];

    public SelectionSort(int[] arr) {
        this.arr = arr;
    }

    private int[] sort(boolean sortOnOriginal, boolean isAsc) {

        int array[] = arr;
        if (!sortOnOriginal) {
            array = ArrayUtils.cloneArray(arr);
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (isAsc) {
                int minPos = ArrayUtils.findMinPosition(array, i);
                ArrayUtils.swap(array, minPos, i);
            } else {
                int maxPos = ArrayUtils.findMaxPosition(array, i);
                ArrayUtils.swap(array, maxPos, i);
            }
        }
        return array;
    }

    public int[] getSortedArray(boolean isAsc) {
        return sort(false, isAsc);
    }

    public void displayCompare() {
        System.out.println("Original arr: ");
        ArrayUtils.displayIntArray(arr);
        System.out.println("Ascending arr: ");
        ArrayUtils.displayIntArray(getSortedArray(true));
        System.out.println("Descending arr: ");
        ArrayUtils.displayIntArray(getSortedArray(false));
    }
}
