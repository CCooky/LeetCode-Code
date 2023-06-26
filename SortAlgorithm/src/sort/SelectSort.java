package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{100,2,3,40,5,10};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums){
        //依次选出最小值，放到数组最前面，选出来n-1个数即可
        for (int i = 0; i < nums.length-1; i++) {
            // i——每次选出最小值放入的位置
            int minIndex = i;
            for (int j = i; j < nums.length ; j++) {
                if (nums[minIndex]>nums[j]){
                    minIndex = j;
                }
            }
            //exchange
            int temp = nums[i];
            nums[i]=nums[minIndex];
            nums[minIndex] = temp;
        }
    }
}
