package com.miga.sortalgorithms;

public class MergeSort {

    public static <T extends Comparable<T>> T[] sort(T[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
        return array;
    }

    public static <T extends Comparable<T>> void merge(T[] array, int left, int mid, int right) {
        T[] temp = array.clone();
        for (int i = left; i <= mid; i++)
            temp[i] = array[i];

        for (int i = mid + 1, j = right; i <= right; i++, j--)
            temp[i] = array[j];

        int i = left;
        int j = right;

        for (int k = left; k <= right; k++) {
            if (temp[i].compareTo(temp[j]) < 1) {
                array[k] = temp[i++];
            } else {
                array[k] = temp[j--];
            }
        }
    }
}
