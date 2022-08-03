package algorithm.C09_MergeSort;

import algorithm.C03_SelectionSort.ArrayGenerator;

import java.util.Arrays;

/**
 * 归并排序法
 * 对整个数组排序，数组拆两半，对每一半排序，对每一半数组继续拆两半，再各自排序...不断调自己
 * O(nlogn)
 */
public class MergeSort {

    public MergeSort() {}

    public static <E extends  Comparable<E>> void sort(E[] arr){
        sort(arr,0,arr.length-1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr,int l,int r){
        if(l>=r) return;

        int mid=l+(r-l)/2;    // (l+r)/2=l+(r-l)/2, (l+r) : r量级非常大可能会超出int

        sort(arr,l,mid);
        sort(arr,mid+1,r);

        merge(arr,l,mid,r);
    }

    // 合并两个有序的区间 arr[l, mid] 和 arr[mid + 1, r]
    public static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {

        E[] temp = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;

        for (int k = i; k <=r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        int n = 100000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//        System.out.println(arr.toString());
//        MergeSort.merge(arr, 0, 1, 3);
//        System.out.println(arr);

        Integer[] arr2=Arrays.copyOf(arr,arr.length);
        Integer[] arr3=Arrays.copyOf(arr,arr.length);

        SortHelper.sortTest("SelectionSort",arr);  // O(n*n)
//        SortHelper.sortTest("InsertionSort",arr2); // O(n*n)
//        SortHelper.sortTest("MergeSort",arr3);  // O(nlog(n))
        /**
         * [Ljava.lang.Integer;@135fbaa4
         * SelectionSort , 100000 ,10.969639988 s
         * [Ljava.lang.Integer;@1d44bcfa
         * InsertionSort , 100000 ,11.104785978 s
         * [Ljava.lang.Integer;@266474c2
         * MergeSort , 100000 ,0.075689857 s
         */

        SortHelper.sortTest("SelectionSortUP",arr);  // O(n*n)
    }
}
