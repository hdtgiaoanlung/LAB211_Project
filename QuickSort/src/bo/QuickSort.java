/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import utils.*;

/**
 *
 * @author dinht
 */
public class QuickSort {

    private final int[] arr;
    private int[] cloneArray;

    public QuickSort(int[] arr) {
        this.arr = arr;
        cloneArray = arr;
    }

    private void sort(int[] arr, boolean isAsc, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partitionIndex = partition(cloneArray, startIndex, endIndex, isAsc);
            sort(arr, isAsc, startIndex, partitionIndex - 1);
            sort(arr, isAsc, partitionIndex + 1, endIndex);
        }
    }

    public int[] getSortedArray(boolean isAsc) {
        sort(cloneArray, isAsc, 0, cloneArray.length - 1);
        return cloneArray;
    }

    private int partition(int arr[], int startIndex, int endIndex, boolean isAsc) {
        int pivot = arr[endIndex];
        int i = startIndex - 1;
        for (int j = startIndex; j <= endIndex - 1; j++) {
            if (isAsc ? arr[j] < pivot : arr[j] > pivot) {
                i++;
                ArrayUtils.swap(arr, i, j);
            }
        }
        ArrayUtils.swap(arr, i + 1, endIndex);
        return (i + 1);
    }
}
