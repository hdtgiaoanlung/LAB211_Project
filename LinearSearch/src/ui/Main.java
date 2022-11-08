/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;

import bo.LinearSearch;
import utils.ArrayUtils;
import utils.NumberUtils;

public class Main {

    public static void main(String[] args) {
        int len = NumberUtils.inputInt("Enter the length of the array: ");
        int[] arr = ArrayUtils.randomIntArray(len, 0, 10);
        
        int searchValue = NumberUtils.inputInt("Enter the search value: ");
        LinearSearch ls = new LinearSearch(arr);
        
        int pos = ls.search(searchValue);
        System.out.println("The array: ");
        ArrayUtils.displayIntArray(arr);
        
        if(pos == -1){
            System.out.println("Not found!");
        } else {
            System.out.println("Found " + searchValue + " at index: " + pos);
        }
    }
    
}
