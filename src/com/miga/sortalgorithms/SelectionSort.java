package com.miga.sortalgorithms;

import com.miga.sortalgorithms.common.SortUtil;

public class SelectionSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(min) == -1) {
                    min = array[j];
                    minIndex = j;
                }
            }
            SortUtil.swap(array, minIndex, i);
        }
        return array;
    }
}
