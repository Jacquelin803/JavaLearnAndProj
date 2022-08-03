package algorithm.C10_QuickSort;


import algorithm.C03_SelectionSort.ArrayGenerator;

import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {

    public QuickSort2() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random rnd = new Random();
        sort(arr, 0, arr.length - 1,rnd);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r,Random rdn) {
        if (l >= r) return;
        int randomInt = l + rdn.nextInt(r - l + 1);
        swap(arr, l, randomInt);
        int p = partition(arr, l, r,rdn);
        sort(arr, l, p - 1,rdn);
        sort(arr, p + 1, r,rdn);
    }

    public static <E extends Comparable<E>> int partition(E[] arr, int l, int r,Random rnd) {

        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        int i = l + 1, j = r;
        while (true) {

            while (i <= j && arr[i].compareTo(arr[l]) <= 0) {
                i++;
            }
            while (i <= j && arr[j].compareTo(arr[l]) >= 0) {
                j--;
            }
            if (i >= j) break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr,j,l);

        return j;
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) throws Exception {
        int n = 50000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//        Integer[] arr2 = ArrayGenerator.generateOrderedArray(n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);


//        SortHelper.sortTest("QuickSort",arr);
        System.out.println(arr);
        SortHelper.sortTest("QuickSort", arr);
        SortHelper.sortTest("QuickSort2", arr2);
    }
}
