
/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 提示：
 *      你可以假设 nums 中的所有元素是不重复的。
 *      n 将在 [1, 10000]之间。
 *      nums 的每个元素都将在 [-9999, 9999]之间。
 */

/**
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 */
public class 二分查找 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int search = search(nums, target);
        System.out.println(search);

        String s = "abc";
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s);
        System.out.println(s1 == s2);

        String s3= "ab" + "cd";
        String s4= "abc" + "d";
        System.out.println(s3 == s4);

    }

    // 暴力解法
    public static int search(int[] nums, int target){
        for(int i=0;i<nums.length;i++){
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分查找法
     * 满足 有序数组+无重复元素，因为一旦有重复元素，使用二分查找法返回的元素下标可能不是唯一的
     */

    public static int goodSolution(int[] nums, int target){
        /**
         *   思路：如果一直没有找到目标数，那么left和right终有一天会相等的，也是由/号的特性导致（数据的自动类型转换，表达式的数据类型由最高数据类型决定）
         *   那么也就是说，最后出现left=right=mid的情况，这种情况即为最后一次判断，如果再不等于目标数，就出现left>right了，此时就不对了，需要停止循环
         */

        // 优化代码：避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;  // 左指针-索引
        int right = nums.length-1;  // 右指针-索引
        int mid = (left+right)/2;  // 中间索引
        int res = -1;  // 最终结果

        while (left<=right){
            if (target>nums[mid]){
                left = mid+1;
                mid = (left+right)/2;
            }else if (target<nums[mid]){
                right = mid -1;
                mid = (left+right)/2;
            }else {
                res = mid;
                break;
            }
        }

        return res;
    }

    public int solution(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;

        while (left<=right){
            if (nums[mid]==target){
                return mid;
            }else if (target>nums[mid]){
                left = mid+1;
                right = right;
                mid = (left+right)/2;
            }else {
                left = left;
                right = mid-1;
                mid = (left+right)/2;
            }
        }
        return -1;
    }

}



