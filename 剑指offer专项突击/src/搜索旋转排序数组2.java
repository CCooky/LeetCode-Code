/**
 * /**
 * * 整数数组 `nums` 按升序排列，数组中的值 有相同的值 。
 * * 给你 **旋转后** 的数组 `nums` 和一个整数 `target` ，如果 `nums` 中存在这个目标值 `target` ，则返回它的下标，否则返回 `-1` 。
 */

public class 搜索旋转排序数组2 {

    public boolean getRes(int[] nums, int target) {
        // 这道题同第二道旋转数组类似，但这个比较难一点一点，重复元素，也是二分法
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;

        while (left <= right) {
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[right]) {
                // [left,mid]
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                mid = left + (right - left) / 2;
            } else if (nums[mid] < nums[right]){
                // [mid, right]
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                mid = left + (right - left) / 2;
            }else {
                // 因为数组重复，所以这里多一种情况，直接抛弃right就行了
                right--;
                mid = left + (right - left) / 2;
            }
        }
        return false;
    }
}
