/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertion.sort;

/**
 *
 * @author Admin
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int valueToInsert;
        for (int index = 1; index < arr.length; index++) {
            valueToInsert = arr[index];
            while (index > 0 && arr[index - 1] > valueToInsert) {
                arr[index] = arr[index - 1];
                index = index - 1;
            }
            arr[index] = valueToInsert;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = {10, 9, 7, 101, 23, 44, 12, 78, 34, 23};
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }

}
