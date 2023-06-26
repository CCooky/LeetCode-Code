package test;

import sort.MergeSort;

import java.util.Arrays;

public class MergeSortTest {
    public static void main(String[] args) {
        int[] nums = new int[]{5,9,3,10,2};
        MergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
