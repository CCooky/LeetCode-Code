package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{100,2,3,40,5,10};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sort(int[] nums){
        //将数组分为有序序列+无序两部分
        //初始时，有序序列就是数组第一个元素，然后依次将无序序列从前往后放入
        for (int i = 1; i < nums.length; i++) { //无序序列
            int k = i; //重要，不加就错了
            for (int j = i-1; j >=0 ; j--) { //有序部分（索引）
                if (nums[k]>=nums[j]){
                     break;
                }else {
                    int temp = nums[k];//exchange
                    nums[k] = nums[j];
                    nums[j] = temp;
                    k = j; //此时新入元素所在位置j
                }
            }
        }
    }
}
