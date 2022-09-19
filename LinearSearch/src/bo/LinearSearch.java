/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

/**
 *
 * @author Administrator
 */
public class LinearSearch {

    private int[] arr;

    public LinearSearch(int[] arr) {
        this.arr = arr;
    }

    private int search(int searchValue) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchValue) {
                return i;
            }
        }
        return -1;
    }
    
    public int getSearchIndex(int searchValue){
        return search(searchValue);
    }
}
