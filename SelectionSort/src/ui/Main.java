/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import java.util.Scanner;
import bo.SelectionSort;
import utils.ArrayUtils;
import utils.NumberUtils;
/**
 *
 * @author dinht
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        System.out.println("SELECTION SORT PROJECT!!!");
        int arrLength = NumberUtils.inputInt("Input length of Array: ", 1, Integer.MAX_VALUE);
        int arr[] = ArrayUtils.randomIntArray(arrLength, 0, 500);
        SelectionSort s = new SelectionSort(arr);
        s.displayCompare();
    }
}
