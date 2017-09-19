package com.miga.sortalgorithms;

import com.miga.sortalgorithms.common.SortUtil;

public class BubbleSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> T[] sort(T array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1].compareTo(array[j]) == 1) {
                    SortUtil.swap(array, j - 1, j);
                }
            }
        }
        return array;
    }
}
