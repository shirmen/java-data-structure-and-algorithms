package com.miga.sort_algorithms;

import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {

        // int array[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int array[] = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }

        bubbleSort(array);
    }

    public static void bubbleSort(int array[]) {
        Scanner keyboard = new Scanner(System.in);
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                    print(array, j - 1);
                    keyboard.nextLine();
                }
            }
        }
        keyboard.close();
    }
    
    public static void print(int array[], int j) {
        for (int i = 0; i < array.length; i++) {
            if (i == j) {
                System.out.print((char)27 + "[33m" + " " + array[i] + " " + (char)27 + "[37m");
            } else if (i == j + 1) {
                System.out.print((char)27 + "[31m" + " " + array[i] + " " + (char)27 + "[37m");
            } else {
                System.out.print(" " + array[i] + " ");
            }
        }
    }

    public static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
