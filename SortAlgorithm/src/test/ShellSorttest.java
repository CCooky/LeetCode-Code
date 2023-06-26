package test;

import sort.MergeSort;
import sort.ShellSort;

import java.util.Arrays;

public class ShellSorttest {
    public static void main(String[] args) {
        int[] nums = new int[]{5,9,3,10,2};
        ShellSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
