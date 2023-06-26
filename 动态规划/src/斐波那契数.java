/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 */
public class 斐波那契数 {
}

class Solution121 {
    public int fib(int n) {
        return FF(n);
    }

    // 这不是递归解决的题目嘛
    public int FF(int n) {
        //2.终止条件
        if (n==0) return 0;
        if (n==1) return 1;
        //3.单层递归逻辑
        return FF(n-1)+FF(n-2);
    }
    /**
     * 由于斐波那契数存在递推关系，因此可以使用动态规划进行求解。状态转移方程就是给的递推条件
     */
    public int DPFib(int n){
        if (n==0) return 0;
        if (n==1) return 1;
        //1.第一dp数组，这里为一维，并且dp[i] 表示每斐波那契数f(n)的值
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        //2.确定递推公式 dp[i] = dp[i-1]+dp[i-2]
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        //3.确定dp的初始化 dp[0]=0,dp[1]=1
        //4.确定遍历顺序，因为dp[i]依赖前面的数，所以从前往后
        return dp[n];
        //5.这里太简单了，不需要推到了
    }

    public int DPFibCompress(int n){
        if (n==0) return 0;
        if (n==1) return 1;
        //1.第一dp数组，这里为一维，并且dp[i] 表示每斐波那契数f(n)的值
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        int sum = 0;
        //2.确定递推公式 dp[i] = dp[i-1]+dp[i-2]
        for (int i = 2; i < n+1; i++) {
            sum = dp[0]+dp[1];
            dp[2] = sum;
            dp[0] = dp[1];
            dp[1] = sum;
        }
        //3.确定dp的初始化 dp[0]=0,dp[1]=1
        //4.确定遍历顺序，因为dp[i]依赖前面的数，所以从前往后
        return dp[2];
        //5.这里太简单了，不需要推到了
    }

}
