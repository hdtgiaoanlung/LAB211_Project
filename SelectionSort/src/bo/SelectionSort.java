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
            int pos = findPosition(array, isAsc, i);
            ArrayUtils.swap(array, i, pos);
        }
        return array;
    }

    private int findPosition(int[] arr, boolean isAsc, int startIndex) {
        int pos = startIndex;
        for (int i = startIndex; i < arr.length; i++) {
            if (isAsc ? arr[i] < arr[pos] : arr[i] > arr[pos]) {
                pos = i;
            }
        }
        return pos;
    }

    public int[] getSortedArray(boolean isAsc) {
        return sort(false, isAsc);
    }
}
