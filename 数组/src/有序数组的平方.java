/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 */


import java.util.Arrays;


public class 有序数组的平方 {
    // 测试代码
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] ints = Solution.sortedSquares2(nums);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}

class Solution {
    // 分析：1、整型数组（负数、0、正数）
    // 2、非递减顺序 即有重复元素的升序排序
    // 因此先原数组每个数平方，然后进行归并排序即可（时间复杂度O(nlogn),且稳定）
    public static int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        // 归并排序
//        MergeSort mergeSort = new MergeSort();
//        return mergeSort.mergeSort(nums);
        // 系统的函数，实际情况可以用不？？？
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 双指针解法
     * 低时间复杂度解法：上面的方法适用于任意数组，但这里给的数组是非递减顺序的，所以说肯定有更快的办法
     * 分析：数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。（有负数）
     * 那么我们可以双指针，一个指向开始，一个指向末尾，就可以依次找到最大值，放到一个新数组里面！！！
     */
    public static int[] sortedSquares2(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        //
        int[] tempArr = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = tempArr.length - 1;
        while (left <= right) {
            if (nums[left] <= nums[right]) {
                tempArr[index] = nums[right];
                index--;
                right--;
            } else {
                tempArr[index] = nums[left];
                index--;
                left++;
            }
        }
        return tempArr;
    }
}
// 从排序算法模块复制来的
class MergeSort {

    // 归并排序的入口
    public int[] mergeSort(int[] nums) {
        // 1、分配辅助数组，存储排序后的元素，最后把这个数组复制给原数组
        int[] tempArr = new int[nums.length];
        // 开始进行归并排序（先分后治）
        split(nums, tempArr, 0, nums.length - 1);
        return nums;
    }


    // 第一个环节：拆分,(left、right--数组索引--表示需要排序的数组范围）
    public void split(int[] nums, int[] tempArr, int left, int right) {
        // 如果只有一个元素，那么就不需要再划分，其本身就是有序的，只需要被归并即可,
        // 也就是left=right时停止划分，开始归并
        if (left == right) {
            return;
        }
        // 找中间点
        int mid = (left + right) / 2;
        // 递归划分左半区
        split(nums, tempArr, left, mid);
        // 递归划分右半区
        split(nums, tempArr, mid + 1, right);
        // 合并两个部分，并且排序(递归就是方法往栈里面压，第一次走到这一步时，说明到了left、right相邻了）
        // 合并【left，mid】和【mid+1，righ】
        merge(nums, tempArr, left, mid, right);
    }

    // 第二个环节：合并
    public void merge(int[] nums, int[] tempArr, int left, int mid, int right) {
        // 用到了核心的双指针
        int index = left;  // 定义指针，指向tempArr数组中开始填充数据的索引
        int p1 = left;  //定义指针，指向第一组数据的第一个元素
        int p2 = mid + 1;  //定义指针，指向第二组数据的第一个元素
        // 遍历1，移动p1指针和p2指针，比较对应索引处的值，将较小的那个放到辅助数组指针对应的索引位置
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                tempArr[index++] = nums[p1++];
            } else {
                tempArr[index++] = nums[p2++];
            }
        }
        // 遍历2，如果p1的指针没有走完，那么顺序移动p1指针，把元素放到辅助数组里面
        while (p1 <= mid) {
            tempArr[index++] = nums[p1++];
        }
        // 遍历3，如果p2的指针没有走完，那么顺序移动p2指针，把元素放到辅助数组里面
        while (p2 <= right) {
            tempArr[index++] = nums[p2++];
        }
        // 复制到原数组，将tempArr的这次排序部分复制过去
        for (int i = left; i <= right; i++) {
            nums[i] = tempArr[i];
        }
    }
}

class Solution01{
    //平方后，排序，非常规排序才行，找数学规律！最大值肯定是两端，所以我们new一个新的
    //双指针
    public int[] myFun(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i]*nums[i];
        }
        //
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int i = 0;
        while (left<=right){
            if (nums[left]>=nums[right]){
                res[i] = nums[left];
                i++;
                left++;
            }else {
                res[i] = nums[right];
                i++;
                right--;
            }
        }
        return res;
    }
}

