package algorithm.C09_MergeSort;

import algorithm.C03_SelectionSort.ArrayGenerator;

import java.util.Arrays;

/**
 * // 自底向上的归并排序
 */
public class MergeSortUP {
    public MergeSortUP() {}


    // 自底向上的归并排序
    public static <E extends Comparable<E>> void sort(E[] arr){

        E[] temp= Arrays.copyOf(arr,arr.length);

        int n=arr.length;

        // 遍历合并的两个区间的起始位置 i
        // 合并 [i, i + sz - 1] 和 [i + sz, Math.min(i + sz + sz - 1, n - 1)]
        // 在各自区间是有序的，只要对比第一个区间最后一个和第二个区间第一个元素就成
        for(int sz=1;sz<n;sz+=sz){
            for(int i=0;i+sz<n;i+=sz+sz){
                if(arr[i+sz-1].compareTo(arr[i+sz])>0){
                    merge(arr,i,i+sz-1,Math.min(i+sz+sz-1,n-1));
                }
            }
        }
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

        Integer[] arr2=Arrays.copyOf(arr,arr.length);

        SortHelper.sortTest("MergeSort",arr);  // O(n*n)

        SortHelper.sortTest("QuickSort",arr2);  // O(n*n)
    }
}
