public class 剪绳子 {
    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1]
     * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * 输入一个n。
     * 输出最大乘积
     */
}

class Solution10 {
    //这就是一个整数拆分的题目啊，根据贪心就是 拆分成n个3，如果最后一个数是4就保留下来，不再拆分；
    public int cuttingRope(int n) {
        if (n<2) return -1;
        //dp算法，递推公式是两个for，j是拆分出的第一个正整数，1<=j<n的，因为最少拆分成两个啊,
        //那么就是j、i-j这两个部分，我们接下来只看一个 i-j 能不能继续拆分即可，两种情况+自身的dp[i]三个进行对比
        int[] dp = new int[n + 1];
        //3.
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        //2.dp[i] = MAX( j*(i-j), j*dp[i-j] )
        for (int i = 3; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                //为什么要和dp[j]比较，因为这个要被执行很多次，在forj的循环下
                dp[i] = Math.max(dp[i], Math.max( j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }


    public int cuttingRope2(int n) {
        if (n<2) return -1;
        if (n==2) return 1;
        if (n==3) return 2;
        if (n==4) return 4;
        //大于3的时候去拆分下面的
        int res = 1;
        while (n>4){
            n = n-3;
            res = res * 3;
        }
        res = res * n;
        return res;
    }
}
