package algorithm.C10_QuickSort;

import algorithm.C03_SelectionSort.ArrayGenerator;

import java.util.Arrays;
import java.util.Random;


/**
 * 三路快速排序：
 * 	三路：
 * 	arr[l+1,lt]<v
 * 	arr[lt+1,i-1]==v
 * 	arr[gt,r]>v
 *
 * 	具体对比过程：
 * 	if(arr[i]<v: lt++;swap(i,lt);i++
 * 	if(arr[i]>v: gt--;swap(i,gt),但i不用++，因为从后面换过来的元素并未进行对比
 * 	if(arr[i]=v: i++
 *
 * 	最后<v的区间变成[l,lt-1]
 *
 * 三路快速排序针对元素全一样的数组复杂度O(n)，因为只需做一次对比
 */
public class QuickSort3 {

    public QuickSort3() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random rnd = new Random();
        sort3ways(arr, 0, arr.length - 1,rnd);
    }


    public static <E extends Comparable<E>> void sort3ways(E[] arr, int l, int r,Random rnd) {

        if(l>=r) return;
        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        int lt = l, i=l+1,gt = r+1;
        while(i<gt){
            if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr,i,gt);
            }
            else if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr,i,lt);
                i++;
            }
            else {
                i++;
            }
        }
        swap(arr, l, lt);

        sort3ways(arr,l,lt-1,rnd);
        sort3ways(arr,gt,r,rnd);
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) throws Exception {
        int n = 500000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = ArrayGenerator.generateOrderedArray(n);
//        Integer[] arr3 = Arrays.copyOf(arr, arr.length);


//        SortHelper.sortTest("QuickSort",arr);
//        System.out.println(arr);
        SortHelper.sortTest("QuickSort", arr);
        SortHelper.sortTest("QuickSort3", arr2);
    }
}
