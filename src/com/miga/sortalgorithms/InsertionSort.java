package com.miga.sortalgorithms;

public class InsertionSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> T[] sort(T array[]) {
        int j;
        T target;

        for (int i = 1; i < array.length; i++) {
            j = i - 1;
            target = array[i];

            while (j >= 0 && array[j].compareTo(target) == 1) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = target;
        }
        return array;
    }
}
