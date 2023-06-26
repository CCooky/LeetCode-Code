/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足，其和 ≥ target 的长度最小的连续子数组 ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class 长度最小的子数组 {
    // 测试方法
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1};
        int target = 15;
        Solution1 solution1 = new Solution1();
        int i = solution1.minSubArrayLen(nums, target);
        System.out.println(i);

    }
}
class Solution1{
    // 分析：从第一个元素开始累计和，直到满足和>=target停止，记录index=1，累计和的元素个数为minK。
    // 再从第二个元素开始累计和，直到.....，记录tempIndex，k，比较k和minK，假如k<minK,则index=tempIndex，minK=K
    // 需要使用两个for循环完成，需要遍历每个下标作为子数组的开始下标，对于每个开始下标，需要遍历其后面的下标得到长度最小的子数组。
    // 时间复杂度：O(n^2) 其中n是数组的长度。暴力解法不通过！！！！！！！！！！！

    /**
     *  掌握滑动窗口法
     *  本质上这道题，就是要找到一个最小长度的窗口，满足需求即可。
     */
    //所谓滑动窗口，就是不断的调节子序列的起始位置和终止位置，从而得出我们要想的结果。
    //在暴力解法中，是一个for循环滑动窗口的起始位置，一个for循环为滑动窗口的终止位置，用两个for循环 完成了一个不断搜索区间的过程。
    //那么滑动窗口如何用一个for循环来完成这个操作呢。
    //首先要思考 如果用一个for循环，那么应该表示 滑动窗口的起始位置，还是终止位置。
    //如果只用一个for循环来表示 滑动窗口的起始位置，那么如何遍历剩下的终止位置？
    //此时难免再次陷入 暴力解法的怪圈。
    //所以 只用一个for循环，那么这个循环的索引，一定是表示 滑动窗口的终止位置。
    public int minSubArrayLen(int[] nums, int target){
        int left = 0;
        int right = 0;
        int len = nums.length;
        int sum = 0;  // 和
        int eleNum = 0;  // 区间元素个数
        int minEleNum = len+1;  // 最少元素个数 （这里初始值怎么取呢，要取一个大的才行, 取len+1即可，因为区间长度肯定<=len，最后判断假如min=len+1，则说明没有满足要求的数组）
        int beginIndex = 0;  // 最短区间起始索引

        // 1.right 从0位置开始往后移动
        while (right<=len-1){
            // 2.每次移动都要计算left-right区间的和sum
            sum += nums[right];
            // 3.判断sum是否大于等于tar；
            // 是：记录区间元素个数eleNum,比较eleNum和minEleNum进行替换（记录left位置） ，然后left移动一位,重新计算sum的值, 然后接着重复第三步，直到sum<target.
            // 否：right往后移动, s
            while (true){
                if (sum>=target){
                    eleNum = right-left +1;
                    if (eleNum<=minEleNum){
                        minEleNum = eleNum;
                        beginIndex = left;
                    }
                    sum -= nums[left]; // 重新计算sum的值
                    left++;
                }else {
                    right++;
                    break;
                }
            }
        }

/**
 * 下面这段代码超时了，我草，应该是因为反复计算sum的原因
 */
//        // 1.right 从0位置开始往后移动
//        while (right<=len-1){
//            // 2.每次移动都要计算left-right区间的和sum
//            sum = 0;
//            for (int i = left;i<=right;i++){
//                sum += nums[i];
//            }
//            // 3.判断sum是否大于等于tar；
//            // 是：记录区间元素个数eleNum,比较eleNum和minEleNum进行替换（记录left位置） ，然后left移动一位,重新计算sum的值, 然后接着重复第三步，直到sum<target.
//            // 否：right往后移动, s
//            while (true){
//                if (sum>=target){
//                    eleNum = right-left +1;
//                    if (eleNum<=minEleNum){
//                        minEleNum = eleNum;
//                        beginIndex = left;
//                    }
//                    left++;
//                    sum = 0;  // 重新计算sum的值
//                    for (int i = left;i<=right;i++){
//                        sum += nums[i];
//                    }
//                }else {
//                    right++;
//                    break;
//                }
//            }
//        }

        return minEleNum==(len+1)?0:minEleNum;
    }
}
