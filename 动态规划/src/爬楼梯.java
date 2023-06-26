import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://leetcode.cn/problems/climbing-stairs/
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */
public class 爬楼梯 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = getRes(n);
        System.out.println(res);
    }
    /**
     * 二刷 ACM;
     * 这个就是一个完全背包问题啊其实，物品重量为1、2，无限个；装满容量为n得背包方案数（排列）
     * 或者简单就直接：
     * dp[i]表示我爬到第N阶的方案数（爬了N个台阶），更简单所以完全背包问题有些地方和爬楼梯类似，可以简化
     */
    //使用普通dp做
    public static int getRes(int n){
        //1. dp[i]：爬i个台阶得方案数，求dp[n]
        int[] dp = new int[n+1];
        //3.
        dp[0] = 1;
        dp[1] = 1;
        //2. dp[i] = dp[i-1] + dp[i-2]
        for(int i=2; i<dp.length;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }



    // 使用完全背包做
    public int climbStairs (int n) {
        // write code here
        // dp-完全背包问题啊，也可以按照常规
        // dp[j]:爬n阶楼梯的方案数，求dp[n]
        int[] dp = new int[n + 1];
        int[] weight = new int[] {1, 2};

        //3.从0个物品挑
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 0;
        }
        //2.
        for (int j = 1; j < dp.length; j++) {
            for (int i = 1; i <= weight.length; i++) {
                if (j - weight[i - 1] >= 0) {
                    dp[j] = dp[j] + dp[j - weight[i - 1]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[n];
    }

}

class Solution3 {
    /**
     * 采用递归的方式会超时啊，我们需要使用DP去搞，DP第一点就是找是不是存在递推关系，
     * 其实我发现了递归/暴力回溯就是没有去利用前后之间的关系！！DP的复杂度时O（N）的
     */
    public int climbStairs(int n) {
        // 需要对初始化的dp先进行return，否则n=1、2时会出现索引越界异常
        if (n == 0) return 0;
        if (n == 1) return 1;

        //1.dp数组以及含义,dp[i]表示我爬到N阶的方案数
        int[] dp = new int[n + 1];
        //3.确定初始话，因为我爬到N阶的方案数，只和爬到N-1阶的方案数、爬到N-2阶的方案数有关，
        // 所以初始化
        dp[0] = 0;
        dp[1] = 1;
        //2.递归关系
        for (int i = 2; i < dp.length; i++) {  // i的上限容易取错，i < n+1
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 因为我只需要和前两个状态相关，所以我可以进行状态压缩，
     * 一种是压缩dp数组长度；一种是使用变量替代dp数组
     */
    public int climbStairsCompress(int n) {
        // 需要对初始化的dp先进行return，否则n=1、2时会出现索引越界异常
        if (n == 1) return 1;
        if (n == 2) return 2;
        //1.dp数组以及含义,dp[i]表示我爬到N阶的方案数
        int[] dp = new int[4];
        //3.确定初始话，因为我爬到N阶的方案数，只和爬到N-1阶的方案数、爬到N-2阶的方案数有关，
        // 所以初始化时要初始化dp[1],dp[2]，(n 大于0啊）
        dp[1] = 1;
        dp[2] = 2;
        //2.递归关系 dp[3]
        for (int i = 3; i < n + 1; i++) {
            dp[3] = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }
}



