package com.miga.sortalgorithms;

public class SelectionSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> T[] sort(T array[]) {
        T min;
        int minIndex = 0;

        for (int i = 0; i < array.length; i++) {
            min = array[i];
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(min) == -1) {
                    min = array[j];
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
        return array;
    }

    public static <T extends Comparable<T>> void swap(T array[], int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
