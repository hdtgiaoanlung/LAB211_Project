/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import utils.ArrayUtils;

/**
 *
 * @author Administrator
 */
public class BinarySearch {

    private int[] arr;

    public BinarySearch(int[] arr) {
        this.arr = arr;
    }

    private int search(boolean searchOnOriginal, int searchValue) {
        int[] array = arr;
        if(!searchOnOriginal){
            array = ArrayUtils.cloneArray(arr);
        }
        Arrays.sort(array);
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (array[mid] == searchValue) {
                return mid;
            }
            if (array[mid] < searchValue) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int getSearchIndex(int searchValue) {
        return search(false, searchValue);
    }
    
    public int[] getSortedArray(){
        int[] array = ArrayUtils.cloneArray(arr);
        Arrays.sort(array);
        return array;
    }
}
