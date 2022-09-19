/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ui;

import bo.QuickSort;
import utils.*;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {

        int length = NumberUtils.inputInt("Enter the length of the array: ");

        int[] arr = new int[length];
        arr = ArrayUtils.getRandomArray(length, 0, 10);
        QuickSort qs = new QuickSort(arr);
        arr = qs.getSortedArray(true);

        int searchValue = NumberUtils.inputInt("Enter the search value: ");
        
        ArrayUtils.displayIntArray(arr);

        int pos = ArrayUtils.BinarySearch(arr, searchValue);
        if (pos == -1) {
            System.out.println("Not found!");
        } else {
            System.out.println("Found " + searchValue + " ar index: " + pos);
        }
    }
}
