package com.miga.sortalgorithms;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
    
        // int array[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int array[] = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }

        insertionSort(array);
    }

    public static void insertionSort(int array[]) {
        int j, target;
        int countComp = 0;

        print(array, 0, 0);
        pause();
        
        for (int i = 1; i < array.length; i++) {
            j = i - 1;
            target = array[i];
            
            while (j >= 0 && array[j] > target) {
                countComp++;
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = target;
            print(array, j, i);
            pause();
        }
        
        System.out.println("Compare = " + countComp);

    }
    
    public static void print(int array[], int j, int i) {
        for(int k = 0; k < array.length; k++) {
            if(k == i + 1) {
                System.out.print((char)27 + "[31m" + " " + array[k] + " " + (char)27 + "[37m");
            } else if(k <= i) {
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
