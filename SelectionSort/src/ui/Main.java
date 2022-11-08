
package ui;

import bo.SelectionSort;
import utils.ArrayUtils;
import utils.NumberUtils;
public class Main {

    public static void main(String[] args) {        
        System.out.println("SELECTION SORT PROJECT!!!");
        int arrLength = NumberUtils.inputInt("Input length of Array: ", 1, Integer.MAX_VALUE);
        int[] arr = ArrayUtils.randomIntArray(arrLength, 0, 500);
        SelectionSort s = new SelectionSort(arr);
        System.out.println("Original arr: ");
        ArrayUtils.displayIntArray(arr);
        System.out.println("Ascending arr: ");
        ArrayUtils.displayIntArray(s.getSortedArray(true));
        System.out.println("Descending arr: ");
        ArrayUtils.displayIntArray(s.getSortedArray(false));
    }
}
