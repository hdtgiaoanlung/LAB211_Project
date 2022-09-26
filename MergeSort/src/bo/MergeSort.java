/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import utils.ArrayUtils;

/**
 *
 * @author Administrator
 */
public class MergeSort {

    private int[] arr;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    private void merge(boolean isAsc, int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;

        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];

        for (int i = 0; i < len1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < len2; j++) {
            rightArr[j] = arr[mid + j + 1];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < len1 && j < len2) {
            if (isAsc ? leftArr[i] <= rightArr[j] : leftArr[i] >= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < len2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    private void sort(boolean isAsc, int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(isAsc, arr, left, mid);
            sort(isAsc, arr, mid + 1, right);
            
            merge(isAsc, arr, left, mid, right);
        }
    }
    
    public int[] getSortedArray(boolean sortOnOriginal, boolean isAsc){
        int[] array = arr;
        if(!sortOnOriginal){
            array = ArrayUtils.cloneArray(arr);
        }
        sort(isAsc, arr, 0, arr.length - 1);
        return array;
    }
}
