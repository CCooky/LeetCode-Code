package test;

import sort.HeapSort;
import sort.QuickSort;

import java.util.Arrays;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] nums = new int[]{100,2,3,40,5,10};
        QuickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
