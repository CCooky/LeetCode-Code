package test;

import sort.HeapSort;

import java.util.Arrays;
public class HeapSortTest {
    public static void main(String[] args) {
        int[] nums = new int[]{100,2,3,40,5,10};
        HeapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
