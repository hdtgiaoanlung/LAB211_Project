/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import utils.ArrayUtils;

/**
 *
 * @author khang
 */
public class BubbleSort {

    private int arr[];

    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    private int[] sort(boolean sortOnOriginArr, boolean isAsc) {
        int array[] = arr;
        if (!sortOnOriginArr) {
            array = ArrayUtils.cloneArray(arr);
        }
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (isAsc) {
                    if (array[i] > array[i + 1]) {
                        ArrayUtils.swap(array, i, i + 1);
                        swapped = true;
                    }
                } else {
                    if (array[i] < array[i + 1]) {
                        ArrayUtils.swap(array, i, i + 1);
                        swapped = true;
                    }
                }
            }
        }
        return array;
    }

    public int[] getSortedArray(boolean isAsc) {
        return sort(false, isAsc);
    }

    public void displayCompare() {
        System.out.println("Original arr:");
        ArrayUtils.displayIntArray(arr);
        System.out.println("Ascending arr");
        ArrayUtils.displayIntArray(getSortedArray(true));
        System.out.println("Descending arr");
        ArrayUtils.displayIntArray(getSortedArray(false));
    }
}
