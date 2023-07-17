package sort;

/**
 * 归并排序算法
 */

public class MergeSort {

    static int[] tempArr; //必须使用辅助数组

    public static void sort(int[] nums) {
        tempArr = new int[nums.length];
        split(nums,0,nums.length-1);
    }

    // 第一个环节：递归拆分,(left、right--数组索引--表示需要排序的数组范围）
    private static void split(int[] nums, int left, int right) {
        //递归终止条件：left=right，只有一个元素时
        if (left == right) return;
        int mid = (left + right) / 2;
        split(nums, left, mid); //递归划分左半区
        split(nums, mid + 1, right); // 递归划分右半区
        merge(nums, left, mid, right); //合并排序
    }

    // 第二个环节：合并
    // 遍历1，移动p1指针和p2指针，比较对应索引处的值，将较小的那个放到辅助数组指针对应的索引位置
    private static void merge(int[] nums, int left, int mid, int right) {
        // 左数组【left，mid】，右数组【mid+1，right】
        // 【双指针+while】这里需要使用辅助数组，先把合并有序的放入辅助数组，然后将有序排好的这部分复制给nums，必须在这里复制过去，因为下次排序和上一次的元素有关
        int p1 = left;
        int p2 = mid + 1;
        int index = left; //tempArr
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                tempArr[index] = nums[p1];
                p1++;index++;
            } else {
                tempArr[index] = nums[p2];
                p2++;index++;
            }
        }
        // 2.判断哪个数组有剩余，前面是必有一个数组遍历完了
        while (p1 <= mid) {
            tempArr[index] = nums[p1];
            p1++;index++;
        }
        while (p2 <= right) {
            tempArr[index] = nums[p2];
            p2++;index++;
        }
        // 3.最后复制这段给原数组
        System.arraycopy(tempArr, left, nums, left, right-left+1);
    }
}
