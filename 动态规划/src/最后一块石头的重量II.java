import java.util.Arrays;

/**
 * https://leetcode.cn/problems/last-stone-weight-ii/
 */
public class 最后一块石头的重量II {
}

class Solution12 {
    public int lastStoneWeightII(int[] stones) {
        // 分析：将石头分成尽可能重量相等的两堆！最好情况就算每一堆重量为 sum/2, 所以我们求出较小那堆的最大重量即可
        // 正整数，并且每个物品使用一次-01背包；求背包容量为sum/2，能装下的最大值，就算那个较小堆的重量！
        // 1.简单判断输入，无边界条件。又不是要整分两部分
        // 基本信息
        int sum = Arrays.stream(stones).sum();
        int bagSize = sum/2;  // 背包容量。这里向下取整无所谓，因为本来这个石头就可能不能整分两部分啊
        int n = stones.length; //物品数量
        int[] weight = stones; //物品重量数组
        //1.dp数组大小含义：dp[j] 容量为j的背包能装下的物品重量最大值，求dp[basSize]
        int[] dp = new int[bagSize+1];

        //3.dp初始化; 物品数量为0,不管背包大小背的最大重量都是0
        Arrays.fill(dp,0);

        //2.递推公式
        //4. 0-1背包一维dp：先物品后倒序背包
        for (int i = 1; i <=n; i++) {
            for (int j = dp.length-1; j >=0; j--) {
                if (j-weight[i-1]>=0){
                    dp[j] = Math.max(dp[j], dp[j-weight[i-1]] + weight[i-1]);
                }else {
                    dp[j] = dp[j];

                }
            }
        }
        return sum-dp[bagSize]-dp[bagSize];
    }

    /**
     *  二维dp
     */
    public int lastStoneWeightII2(int[] stones) {
        // 简单判断，如果只有一块石头
        if (stones.length == 1) return stones[0];
        //基本信息
        int N = stones.length; //物品个数（石头个数）
        int sum = Arrays.stream(stones).sum();
        int K = sum / 2; //背包容量（向下取整这里不影响这道题）
        int[] weight = stones; // 石头的重量数组

        //1.dp: 从前 i 个石头选，容量为j的背包背的最大重量
        int[][] dp = new int[N + 1][K + 1];

        //3.dp
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        //2.递推公式
        for (int i = 1; i <dp.length; i++) { //石头，前i个石头
            for (int j = 1; j <dp[0].length; j++) { //
                if (j - weight[i - 1]>=0){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + weight[i - 1]);
                }else {
                    dp[i][j] = dp[i - 1][j];

                }
            }
        }

        // dp[N][K] 是当前背包的最大重量，也就是第一堆石头的重量
        return Math.abs(sum-dp[N][K] - dp[N][K]);
    }


}
