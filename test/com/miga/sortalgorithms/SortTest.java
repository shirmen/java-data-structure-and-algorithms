package com.miga.sortalgorithms;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SortTest {

    private static final int SIZE = 10000;
    private static Integer[] sorted = new Integer[SIZE];
    private static Integer[] unsorted = new Integer[SIZE];
    private static Random random = new Random();

    @Before
    public void setUp() {
        for (int i = 0; i < SIZE; i++) {
            sorted[i] = random.nextInt(SIZE);
        }
        unsorted = sorted.clone();
        Arrays.sort(sorted);
    }

    @Test
    public void testInsertionSort() {
        assertTrue(Arrays.equals(InsertionSort.sort(unsorted), sorted));
    }

    @Test
    public void testSelectionSort() {
        assertTrue(Arrays.equals(SelectionSort.sort(unsorted), sorted));
    }

    @Test
    public void testBubbleSort() {
        assertTrue(Arrays.equals(BubbleSort.sort(unsorted), sorted));
    }

    @Test
    public void testQuickSort() {
        assertTrue(Arrays.equals(QuickSort.sort(unsorted, 0, SIZE - 1), sorted));
    }

    @Test
    public void testMergeSort() {
        assertTrue(Arrays.equals(MergeSort.sort(unsorted, 0, SIZE - 1), sorted));
    }

}
