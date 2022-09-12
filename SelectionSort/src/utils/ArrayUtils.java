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

    /**
     *
     * @param arr
     * @param newLineCount
     */
    public static void displayIntArray(int arr[]) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] randomIntArray(int length, int min, int max) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = NumberUtils.getRandomNumberInRange(min, max);
        }
        return array;
    }

    public static void swap(int array[], int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static int[] cloneArray(int arr[]) {
        int ret[] = new int[arr.length];
        int c = 0;
        for (int i : arr) {
            ret[c++] = i;
        }
        return ret;
    }

    public static int findMinPosition(int arr[], int startIndex) {
        int minPos = startIndex;
        for (int i = startIndex; i < arr.length; i++) {
            if (arr[i] < arr[minPos]) {
                minPos = i;
            }
        }
        return minPos;
    }

    public static int findMaxPosition(int arr[], int startIndex) {
        int maxPos = startIndex;
        for (int i = startIndex; i < arr.length; i++) {
            if (arr[i] > arr[maxPos]) {
                maxPos = i;
            }
        }
        return maxPos;
    }

    public static int partition(int[] arr, int startIndex, int endIndex, boolean isAsc) {
        int pivot = arr[endIndex];
        int i = startIndex - 1;
        for (int j = startIndex; j < endIndex - 1; j++) {
            if (isAsc) {
                if (arr[j] < pivot) {
                    i++;
                    ArrayUtils.swap(arr, i, j);
                }
            } else {
                if (arr[j] > pivot) {
                    i++;
                    ArrayUtils.swap(arr, i, j);
                }
            }
        }
        ArrayUtils.swap(arr, i + 1, endIndex);
        return i + 1;
    }
    
    public static int linearSearch(int[] arr, int searchValue){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == searchValue){
                return i;
            }
        }
        return -1;
    }
    
    
}
