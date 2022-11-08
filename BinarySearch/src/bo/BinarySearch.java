/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class BinarySearch {

    private final int[] arr;
    private final int[] cloneArr;

    public BinarySearch(int[] arr) {
        this.arr = arr;
        cloneArr = ArrayUtils.cloneArray(arr);
        Arrays.sort(cloneArr);
    }

    public int search(int searchValue) {
        int low = 0, high = cloneArr.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (cloneArr[mid] == searchValue) {
                return mid;
            }
            if (cloneArr[mid] < searchValue) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    public int[] getSortedArray(){
        return cloneArr;
    }
}
