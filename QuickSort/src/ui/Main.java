/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import bo.QuickSort;
import utils.*;
/**
 *
 * @author dinht
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr;
        System.out.println("Quick Sort Project!!!");
        int length = NumberUtils.inputInt("Enter the length of the array: ", 0, 500);
        arr = ArrayUtils.getRandomArray(length, 0, 500);
        QuickSort qs = new QuickSort(arr);
        System.out.println("Original array: ");
        ArrayUtils.displayIntArray(arr);
        System.out.println("Ascending array: ");
        ArrayUtils.displayIntArray(qs.getSortedArray(false, true));
        System.out.println("Descending array: ");
        ArrayUtils.displayIntArray(qs.getSortedArray(false, false));
    }
    
}
