package algorithm.C10_QuickSort;

import algorithm.C03_SelectionSort.ArrayGenerator;

import java.util.Random;

public class LeetCode75 {

    public LeetCode75(){}
    
    public static void sort(Integer[] nums) {

        sortLC75(nums);
    }

    public static void sortLC75(Integer[] arr){

        int i=0,lt=-1,gt=arr.length;

        while (i<gt){
            if(arr[i]==0){
                lt++;
                swap(arr,lt,i);
                i++;
            }else if(arr[i]==2){
                gt--;
                swap(arr,gt,i);
            }else {
                i++;
            }
        }
    }

    public static void swap(Integer[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public static void main(String[] args) throws Exception{
        int n = 3;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//        Integer[] arr2 = ArrayGenerator.generateOrderedArray(n);
//        Integer[] arr3 = Arrays.copyOf(arr, arr.length);


//        SortHelper.sortTest("QuickSort",arr);
//        System.out.println(arr);
//        SortHelper.sortTest("LeetCode75", arr);
//        SortHelper.sortTest("QuickSort3", arr2);
        LeetCode75.sortLC75(arr);
    }
}
