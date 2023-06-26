import java.util.Arrays;
import java.util.Scanner;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。你可以认为每种硬币的数量是无限的。
 *
 *  1 <= coins[i] <= 231 - 1
 */
public class 零钱兑换 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int aim = in.nextInt();
        int[] weight = new int[n];
        for(int i=0; i<n;i++){
            weight[i] = in.nextInt();
        }
        getRes(weight,aim);
    }
    //装满背包最少物品数，且物品数量无限。属于完全背包问题（好像和组合排列无关系）
    public static int getRes(int[] weight, int bagSize){
        int n = weight.length;
        //dp[i][j] ：从i个物品选，容量为j背包装满最少物品个数。求dp[n][bagSize]
        int[][] dp = new int[n+1][bagSize+1];

        //3.这里需要第一行，还需要第一列哦
        dp[0][0] = 0;
        for(int i=1; i<dp[0].length;i++){
            dp[0][i] = Integer.MAX_VALUE-2;
        }
        for(int i = 1; i<dp.length;i++){
            dp[i][0] = 0;
        }

        //2. 第i个物品能否放入（注意可以重复放入）
        // dp[i][j] = dp[i-1][j];
        // dp[i][j] = Math.min( dp[i-1][j], dp[i][j-weight[i-1]] +1 );
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(j-weight[i-1]>=0){
                    dp[i][j] = Math.min( dp[i-1][j], dp[i][j-weight[i-1]] +1 );
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][bagSize]);
        return dp[n][bagSize];
    }
}

class Solution20 {

    // 组合问题：每个元素可以重复使用，求满足总和的最短组合。
    // 由于元素都是正整数，每个元素有无限个，==》》完全背包可解
    public int coinChange(int[] coins, int amount) {

        //1.简单判断输入
        if (amount<0) return -1;
        //完全背包思路：dp[j]表示容量为j的背包装满的最少物品个数；到第i个物品时，dp[j] = min( dp[j] , dp[j-weight[i-1]] + 1)
        // 基本信息
        int bagSize = amount;
        int n = coins.length;
        int[] weight = coins;
        //1.dp数组含义：dp[j]表示容量为j的背包装满的最少物品个数, 求dp[bagSize]
        int[] dp = new int[bagSize+1];

        //3.dp初始阿虎; 物品数量为0
        //容量大于0，装满的最少物品个数。这里装不满啊根本，肯定不能写0，那写无穷大？对就是无穷大这里;分析不出的话可以根据递推公式分析，不能被初始值覆盖
        Arrays.fill(dp,Integer.MAX_VALUE-2);
        dp[0] = 0; // 容量为0时，

        //2.递推公式
        //4.遍历顺序；正序遍历背包，不是求装满的方案数，这里两个for无所谓
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=bagSize; j++) {
                //如果第i个物品可以放下
                if (j-weight[i-1]>=0){
                    dp[j] = Math.min(dp[j], dp[j-weight[i-1]]+1); //这里最大值加1会越界
                }else {
                    dp[j] = dp[j]; //不放入第i物品时最少物品个数
                }
            }
        }
//        return dp[bagSize];
        // 易错点这里：加入大小为bagSize的背包最后就装不满的话，应该返回-1，装不满时这个dp[bagSize]是不是就等于初始值啊
        if (dp[bagSize] == Integer.MAX_VALUE-2){
            return -1;
        }
        return dp[bagSize];
    }
}
