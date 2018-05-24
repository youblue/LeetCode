package io;

/**
 * Created by wzhang01 on 5/24/2018.
 */
public class QuickSort {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start >= end) {
            return;
        }
        int pivot = arr[start];

        int i = 1, j = arr.length - 1;
        while(i <= j) {
            if (arr[i] < pivot) {
                i++;
                continue;
            }
            if (arr[j] > pivot) {
                j--;
                continue;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, start, j);
        quickSort(arr, start, j-1);
        quickSort(arr, i, end);
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 4, 1, 2};
        quickSort(arr, 0, arr.length-1);
        for (int x : arr) {
            System.out.println(x);
        }
    }
}
