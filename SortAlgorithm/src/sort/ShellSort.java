package sort;

import java.util.Arrays;

public class ShellSort {

    public static void sort(int[] nums) {
        int h = nums.length / 2; //初始增量
        while (h >= 1) {
            // h增量，==1是最后一次插入排序
            for (int i = h; i < nums.length; i++) {
                // i——要插入的元素，他和前面的元素进行插入排序
                for (int j = i - h; j >= 0; j -= h) {
                    if (nums[i] >= nums[j]) break;
                    else {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        i = j;
                    }
                }
            }
            // 缩小增量
            h = h / 2;
        }
    }


}
