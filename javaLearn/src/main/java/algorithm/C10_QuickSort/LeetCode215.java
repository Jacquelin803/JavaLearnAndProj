package algorithm.C10_QuickSort;


import algorithm.C03_SelectionSort.ArrayGenerator;

import java.util.Random;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * ******no
 */
public class LeetCode215 {

    public LeetCode215(){}

    public static int findKthLargest(Integer[] nums, int k) {
        Random rnd = new Random();
        sort(nums,0,nums.length-1,rnd);

        int numK=nums[nums.length-k];
        return numK;

    }

    public static void sort(Integer[] nums,int l,int r,Random rnd){
        if(l>=r) return;

        int lt=l,gt=r+1;
        int i=l+1;
        int p= rnd.nextInt(r-l+1);
        swap(nums,l,p);

        while(i<gt){

            if(nums[i]<nums[l]){
                lt++;
                swap(nums,lt,i);
                i++;
            }else if(nums[i]>nums[l]){
                gt--;
                swap(nums,gt,i);
            }else {
                i++;
            }
        }
        swap(nums,l,lt);

        sort(nums,l,lt-1,rnd);
        sort(nums,gt,r,rnd);

//        return nums;
    }
    public static void swap(Integer[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int n = 6;

//        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = ArrayGenerator.generateOrderedArray(n);
        for(int i : arr2){
            System.out.println("arr"+i);
        }
        int numK=LeetCode215.findKthLargest(arr2,2);
        for(int i : arr2){
            System.out.println("arr __"+i);
        }
        System.out.println(numK);
    }
}
