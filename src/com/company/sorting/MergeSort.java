package com.company.sorting;

public class MergeSort {
    public static void sort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Populate left and right arrays
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        sort(left);    // Recursively sort the left subarray
        sort(right);   // Recursively sort the right subarray

        merge(left, right, array);   // Merge the sorted left and right subarrays
    }

    public static void merge(int[] left, int[] right, int[] result) {
        int i = 0;  // Index for the left array
        int j = 0;  // Index for the right array
        int k = 0;  // Index for the merged array

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from the left subarray, if any
        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements from the right subarray, if any
        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }
    }

}
