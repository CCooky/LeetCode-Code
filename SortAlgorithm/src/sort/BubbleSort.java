package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{100,2,3,40,5,10};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sort(int[] nums){
        //依次冒泡出最大值到数组末尾，冒泡完后的最大值不参与后续冒泡,每次都是从第一个开始
        //对比选择排序，是排序好的放在数组最前面，这里是最后面
        for (int i = nums.length-1; i >=0; i--) { //i——此次冒泡好的最大值位置
            for (int j = 0; j <= i-1; j++) { //冒泡范围
                if (nums[j]>nums[j+1]){
                    int temp = nums[j]; //exchange
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    //然后不需要移动j位置，因为后面有j++，会保证下一个j指向上次两个比较的最大值
                }
            }
            
        }
        
    }
}
