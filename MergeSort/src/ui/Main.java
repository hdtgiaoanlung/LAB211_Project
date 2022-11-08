package ui;

import bo.MergeSort;
import utils.ArrayUtils;
import utils.NumberUtils;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to my demo project!");
        int arrLength = NumberUtils.inputInt("Input length of Array: ", 1, Integer.MAX_VALUE);
        int[] arr = ArrayUtils.randomIntArray(arrLength, 0, 500);
        System.out.println("Original Array: ");
        ArrayUtils.displayIntArray(arr);
        MergeSort b = new MergeSort(arr);
        System.out.println("Ascending Array: ");
        ArrayUtils.displayIntArray(b.getSortedArray(false, true));
        System.out.println("Descending Array: ");
        ArrayUtils.displayIntArray(b.getSortedArray(false, false));
    }
}
