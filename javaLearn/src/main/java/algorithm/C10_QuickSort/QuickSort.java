package algorithm.C10_QuickSort;

import algorithm.C03_SelectionSort.ArrayGenerator;


import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序法：选取一个元素，比这个元素小的划在左边，比这个元素大的划在右边。
 * 递归调用这个过程，将大任务逐步划为小任务
 */
public class QuickSort {

    public QuickSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if(l>=r) return;
        int randomInt=l+(new Random()).nextInt(r-l+1);
        swap(arr,l,randomInt);
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {

        // arr[l+1...j] < v ; arr[j+1...i] >= v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, j, l);
        return j;
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) throws Exception{
        int n = 50000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2= ArrayGenerator.generateOrderedArray(n);
//        Integer[] arr2 = Arrays.copyOf(arr, arr.length);


//        SortHelper.sortTest("QuickSort",arr);
        SortHelper.sortTest("QuickSort",arr);
        SortHelper.sortTest("QuickSort",arr2);
        /**
         * [Ljava.lang.Integer;@6d6f6e28
         * QuickSort , 1000000 ,0.186787316 s
         * [Ljava.lang.Integer;@6f94fa3e
         * MergeSort , 1000000 ,0.744170376 s
         */
    }
}
