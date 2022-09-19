/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Administrator
 */
public class BinarySearch {

    private ArrayList<Integer> arr = new ArrayList<Integer>();

    public BinarySearch(int[] arr) {
        arrayToList(arr);
    }

    private int search(int searchValue) {
        Collections.sort(arr);
        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (arr.get(mid) == searchValue) {
                return mid;
            }
            if (arr.get(mid) < searchValue) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int getSearchIndex(int searchValue) {
        return search(searchValue);
    }

    private void arrayToList(int[] arr) {
        for (int i : arr) {
            this.arr.add(i);
        }
    }
}
