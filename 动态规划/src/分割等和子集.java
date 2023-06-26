import java.util.Arrays;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class 分割等和子集 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        int[] nums = new int[]{1, 1, 2, 4};
        System.out.println(solution10.canPartition2(nums));
    }
}

class Solution10 {
    /**
     * 二维dp[i] [j]数组直接表示从i个物品选，容量为j的背包能不能装满-true/false；
     */
    public boolean canPartition3(int[] nums){
        int sum = Arrays.stream(nums).sum();
        if (sum%2!=0)   return false;
        int bagSize = sum/2; //背包容量
        int n = nums.length; //物品个数
        int[] weight = nums;

        //1.
        boolean[] dp = new boolean[bagSize+1];
        Arrays.fill(dp, false);
        dp[0] = true;
        //3.
        //2.
        //4.
        for (int i = 1; i <=n; i++) {
            for (int j = bagSize; j >=1; j--) {
                if (j-weight[i-1]>=0){
                    dp[j] = dp[j] || dp[j-weight[i-1]];
                }else{
                    dp[j] = dp[j];
                }
            }
        }
        return dp[bagSize];
    }
    /**
     * [[状态压缩]]
     */
    public boolean canPartition1(int[] nums) {
        // 求数组内能否找到一个组合，其和刚好等于 sum的一半（每个数使用一次且正整数：问01背包能否正好装满？）
        // 简单判断，假如可以分割，那由于子集都是正整数，所以子集和也是正整数，那么2*子集和 = 正偶数
        int sum = Arrays.stream(nums).sum();
        if (sum%2!=0)   return false;
        int bagSize = sum/2; //背包容量
        int n = nums.length; //物品个数
        int[] weight = nums;
        //1.dp数组以及含义：dp[j]--容量为j的背包，可以装的最大重量？求dp[bagSize]
        int[] dp = new int[bagSize+1];
        //3. dp数组初始阿化
        dp[0] = 0; //物品数为0,最大重量为0
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 0;
        }

        //2.递推公式 对于第i个物品，dp[j] = Math.max( d[j], dp[j-weight[i-1]]+weight[i-1]] )
        // 遍历顺序：先遍历物品、后倒序遍历背包
        for (int i = 1; i <= n; i++) {
            for (int j = dp.length-1; j >=0 ; j--) {
                if (j-weight[i-1]>=0){
                    dp[j] = Math.max(dp[j], dp[j-weight[i-1]]+weight[i-1]);
                }else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[bagSize]==bagSize;

    }

    /**
     * dp数组以及含义; 可选物品为N个(物品是按照顺序拿的,N代表拿的是前N个物品), 背包容量为subSum, 能背下的最大价值
     * return dp[N][K] == K;
     */
    public boolean canPartition2(int[] nums) {
        if (nums.length < 2) return false;
        // DP, 单个背包容量是 sum/2
        int parts = 2;
        int sum = Arrays.stream(nums).sum();
        if (sum % parts != 0) return false;
        int subSum = sum / parts;

        //1.dp数组以及含义; 可选物品为N个(物品是按照顺序拿的,N代表拿的是前N个物品), 背包容量为subSum, 能背下的最大价值
        // dp[i, j]: 可选物品为i个,背包容量为j, 能背下的最大价值; 目标求 dp[N][K]
        int[] weight = Arrays.copyOfRange(nums, 0, nums.length);
        int[] value = Arrays.copyOfRange(nums, 0, nums.length);
        int N = nums.length; // 物品个数
        int K = subSum; //背包容量
        int[][] dp = new int[N + 1][K + 1];

        //3.初始化dp
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        //2.递推公式 dp[i][j] = Max( dp[i-1][j] , dp[i-1][j-weight[i-1]] + value[i-1] )
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j - weight[i - 1] >= 0 && j - weight[i - 1]<dp[0].length) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][K] == K;
    }



}
