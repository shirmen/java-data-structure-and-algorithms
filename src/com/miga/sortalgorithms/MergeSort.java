package com.miga.sortalgorithms;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    public static int array[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    public static int tmp[] = new int[array.length];
    public static void main(String[] args) {
        // int array[] = new int[10];
        // Random random = new Random();
        // for (int i = 0; i < array.length; i++) {
        //     array[i] = random.nextInt(10);
        // }
        
        mergeSort(0, array.length - 1);
    }
    
    public static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
            print(left, mid, right);
            pause();
        }
    }
    
    public static void merge(int left, int mid, int right) {
        for (int i = left; i <= mid; i++)
            tmp[i] = array[i];
        
        for (int i = mid + 1, j = right; i <= right; i++, j--)
            tmp[i] = array[j];

        int i = left;
        int j = right;

        for (int k = left; k <= right; k++) {
            if (tmp[i] <= tmp[j]) {
                array[k] = tmp[i++];
            } else {
                array[k] = tmp[j--];
            }
        }
    }
    
    public static void print(int left, int mid, int right) {
        for (int k = 0; k < array.length; k++) {
            if (k >= left && k <= mid) {
                System.out.print((char)27 + "[32m" + " " + array[k] + " " + (char)27 + "[37m");
            } else if (k >= mid + 1 && k <= right) {
                System.out.print((char)27 + "[31m" + " " + array[k] + " " + (char)27 + "[37m");
            } else {
                System.out.print(" " + array[k] + " ");
            }
        }
    }
    
    public static void pause() {
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
    }
}
