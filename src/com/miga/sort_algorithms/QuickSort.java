package com.miga.sort_algorithms;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        
        // int array[] = {4, 8, 3, 5, 11, 9, 0, 7, 5, 6};
        int array[] = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        
        quickSort(array, 0, array.length - 1);
    }
    
    public static void quickSort (int array[], int left, int right) {
        int i = left;
        int j = right;
        int pivot = array[(left + right) / 2];

        while (true) {
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;

            if (i >= j) break;
            
            if (array[i] != array[j])
                swap(array, i, j);
            
            print(array, left, right, i, j);
            pause();
            i++;
            j--;
        }
        
        if (left < i - 1)
            quickSort (array, left, i - 1);
        
        if (j + 1 < right)
            quickSort (array, j + 1, right);
    }
    
    public static void print(int array[], int left, int right, int i, int j) {
        for (int k = 0; k < 10; k++) {
            if (k == (left + right) / 2) {
                System.out.print((char)27 + "[32m" + " " + array[k] + " " + (char)27 + "[37m");
            } else if (k == i) {
                System.out.print((char)27 + "[31m" + " " + array[k] + " " + (char)27 + "[37m");
            } else if (k == j) {
                System.out.print((char)27 + "[33m" + " " + array[k] + " " + (char)27 + "[37m");
            } else {
                System.out.print(" " + array[k] + " ");
            }
        }
    }
    
    public static void pause() {
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
    }
    
    public static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
