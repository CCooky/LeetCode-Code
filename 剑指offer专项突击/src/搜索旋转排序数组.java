import sun.nio.ch.SelectorImpl;

/**
 * 整数数组 `nums` 按升序排列，数组中的值 互不相同 。
 * 给你 **旋转后** 的数组 `nums` 和一个整数 `target` ，如果 `nums` 中存在这个目标值 `target` ，则返回它的下标，否则返回 `-1` 。
 */
public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        new 搜索旋转排序数组().getRes(nums,target);
    }

    public int getRes(int[] nums, int target) {
        // 这道题同第一道旋转数组类似，但这个比较简单一点，无重复元素，也是二分法
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;

        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[right]) {
                // 【left,mid】区间有序，我们直接判断
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid-1;
                }else {
                    left = mid+1;
                }
                mid = left + (right - left) / 2;
            } else {
                // [mid, right] 区间有序
                if (target > nums[mid] && target <= nums[right]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
                mid = left + (right - left) / 2;
            }
        }
        return -1;
    }
}
