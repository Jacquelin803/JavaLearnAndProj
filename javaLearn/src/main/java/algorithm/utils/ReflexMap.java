package algorithm.utils;

import java.util.HashMap;


public class ReflexMap{
    static final HashMap<String,String> map = new HashMap<String, String>();
    static {
        map.put("SelectionSort", "algorithm.C03_SelectionSort.SelectionSort");
        map.put("InsertionSort", "algorithm.C04_InsertionSort.InsertionSort");
        map.put("MergeSort", "algorithm.C09_MergeSort.MergeSort");
        map.put("MergeSortUP", "algorithm.C09_MergeSort.MergeSortUP");
        map.put("QuickSort", "algorithm.C10_QuickSort.QuickSort");
        map.put("QuickSort2", "algorithm.C10_QuickSort.QuickSort2");
        map.put("QuickSort3", "algorithm.C10_QuickSort.QuickSort3");
        map.put("LeetCode75", "algorithm.C10_QuickSort.LeetCode75");
//        map.put("dataload", "algorithm.C03_SelectionSort.SelectionSort");

    }


    public static String get(String key){
        return map.get(key);
    }




}