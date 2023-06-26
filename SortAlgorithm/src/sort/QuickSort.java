package sort;

public class QuickSort {
    // 入口
    public static void sort(int[] nums) {
        recursion(nums, 0, nums.length - 1);
    }

    //递归
    private static void recursion(int[] nums, int left, int right) {
        if (left >= right) return;

        int value = nums[right];//分解值，索引是right处
        //移动元素，进行分区,将所有比value小的放在数组最前面；采用双指针单移动法
        int slow = left; //最后slow指针左边元素均小于value（不含value）
        int fast = left;
        while (fast < right) {
            if (nums[fast] < value) {
                int tt = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tt;
                slow++;
            }
            fast++; //这个是一定++的啊，之前写错了
        }
        // 最后交换slow指针和value基准值的元素; slow指针索引是基准值所在位置
        int tt = nums[slow];
        nums[slow] = nums[right];
        nums[right] = tt;
        //
        recursion(nums, left, slow - 1); //左区间递归
        recursion(nums, slow + 1, right);
    }

}
