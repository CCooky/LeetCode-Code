
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/target-sum/description/
 * 0 < nums[i] <= 1000
 */
public class 目标和 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int[] nums = new int[]{1,1,2};
        int ways = solution13.findTargetSumWays(nums, 2);
        System.out.println(ways);
    }
}

class Solution13 {

    public int findTargetSumWays(int[] nums, int target) {
        // 组合问题，可以回溯；但是这个只有正整数、每个数使用一次，所以可以使用01背包求 背满的方案数
        // 分到符号数为+的这边的：元素总和*2 = （sum+target)
        // 1.简单判断输入; 如果target大于nums里面全是+号，肯定为0，小于nums里面全是-号，肯定为0
        int sum = Arrays.stream(nums).sum();
        if (Math.abs(target)>sum) return 0;
        // 还有分到+号的，元素总和肯定为非负整数，那么（sum+target)肯定是非负偶数，否则为0
        if ((sum+target)%2!=0) return 0;
        // 01背包基本信息
        int bagSize = (sum+target)/2; //背包大小
        int n = nums.length; //物品个数
        int[] weight = nums; //重量数组

        // 01背包，物品只能使用一次，所以先物品后倒序遍历数组（防止放入物品多次，防止背包只放入一个物品）
        //1.dp数组以及含义；使用一维；dp[j]: 容量为j的背包，背满的方案数
        int[] dp = new int[bagSize+1];

        //3.初始化dp. 可选物品数为0
        Arrays.fill(dp, 0);
        dp[0] = 1; // 不放就是满的，也是一种, 其他的都0种方案

        //2.递推公式
        //4. 01背包，先物品后倒序背包
        for (int i = 1; i <=n; i++) {
            for (int j = bagSize; j>=0; j--) {
                // 对于第i个物品
                if (j-weight[i-1]>=0){
                    dp[j] = dp[j] + dp[j-weight[i-1]]; // 不放入i物品方案数+放入i物品方案数
                }else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[bagSize];
    }

}
