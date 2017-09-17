package com.miga.sortalgorithms;
import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
    
        // int array[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int array[] = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }

        selectionSort(array);
    }

    public static void selectionSort(int array[]) {
        int min = 0;
        int minindex = 0;
        int countComp = 0;

        for (int i = 0; i < array.length; i++) {
            min = array[i];
            minindex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    countComp++;
                    min = array[j];
                    minindex = j;
                }
            }
            print(array, minindex, i);
            pause();
            swap(array, minindex, i);
        }
        
        System.out.println("Compare = " + countComp);
    }
    
    public static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void print(int array[], int minindex, int i) {
        for(int k = 0; k < array.length; k++) {
            if(k == minindex) {
                System.out.print((char)27 + "[31m" + " " + array[k] + " " + (char)27 + "[37m");
            } else if(k < i) {
                System.out.print((char)27 + "[32m" + " " + array[k] + " " + (char)27 + "[37m");
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
