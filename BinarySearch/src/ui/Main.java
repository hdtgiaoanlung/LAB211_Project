/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ui;

import bo.BinarySearch;
import utils.*;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {

        int length = NumberUtils.inputInt("Enter the length of the array: ");

        int[] arr = ArrayUtils.getRandomArray(length, 0, 10);

        int searchValue = NumberUtils.inputInt("Enter the search value: ");
        BinarySearch bs = new BinarySearch(arr);

        int pos = bs.search(searchValue);
        System.out.println("Sorted Array: ");
        ArrayUtils.displayIntArray(bs.getSortedArray());
        if (pos == -1) {
            System.out.println("Not found!");
        } else {
            System.out.println("Found " + searchValue + " ar index: " + pos);
        }
    }
}
