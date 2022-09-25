/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ui;

import bo.MergeSort;
import utils.ArrayUtils;
import utils.NumberUtils;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        int len = NumberUtils.inputInt("Enter the length of the array: ");
        int[] arr = ArrayUtils.getRandomArray(len, 0, 100);
        
        MergeSort ms = new MergeSort(arr);
        
        System.out.println("Original Array: ");
        ArrayUtils.displayIntArray(arr);
        System.out.println("Sorted Array: ");
        ArrayUtils.displayIntArray(ms.getSortedArray(true));
        System.out.println("Descending Array: ");
        ArrayUtils.displayIntArray(ms.getSortedArray(false));
    }
}
