
package ui;
import bo.QuickSort;
import utils.*;

public class Main {

    public static void main(String[] args) {
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
