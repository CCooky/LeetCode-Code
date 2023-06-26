import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。1 <= n <= 104
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class 完全平方数 {
}

class Solution21 {
    public int numSquares(int n) {
        //分析：知道了n之后，就可以知道 候选的完全平方数是哪些了，选取里面的数，可以重复选取，和为n，求满足的选取组合的长度最短是多少
        // 可以使用回溯，需要先确定候选的数据集合；由于候选的都是正整数，每个元素可以重复选，可以使用完全背包求最少的物品个数！
        List<Integer> weight = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) { //这里不包括0，题目意思说了
            weight.add(i*i);
        }
        //基本信息
        int bagSize = n; //背包容量
        int N = weight.size(); // 物品个数
        //1.dp数组含义：dp[j]表示容量为j的背包装满最少的物品数
        int[] dp = new int[bagSize+1];

        //3.初始化
        Arrays.fill(dp,Integer.MAX_VALUE-2); //容量大于0，根本放不满，根据递推公式知道取最大值，保证不覆盖。-2保证不溢出
        dp[0] = 0; //不放就是放满了，物品数为0

        //2.递推公式
        //4.遍历顺序，背包正序即可
        for (int i = 1; i <=N; i++) {
            for (int j = 1; j <=bagSize; j++) {
                if (j- weight.get(i - 1) >=0){
                    dp[j] = Math.min(dp[j], dp[j- weight.get(i - 1)]+1);
                }else {
                    dp[j] = dp[j];
                }
            }
        }
        if (dp[bagSize]==Integer.MAX_VALUE-2){
            return 0; //放不满就
        }
        return dp[bagSize];
    }
    /**
     * 二维dp，完全背包
     */
    public int numSquares2(int n){
        List<Integer> weight = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) { //这里不包括0，题目意思说了
            weight.add(i*i);
        }
        //基本信息
        int bagSize = n; //背包容量
        int N = weight.size(); // 物品个数
        //1.dp数组。dp[i][j]：从i个物品选，装满容量j的背包最少的物品个数。求dp[N][bagSize]
        int[][] dp = new int[N+1][bagSize+1];
        //3.dp数组初始化: 第一行
        dp[0][0] = 0;
        for (int i = 1; i < dp[0].length; i++) { //就装不满！！取物品个数最大值-2，因为防止递推公式溢出啊
            dp[0][i] = Integer.MAX_VALUE-2;
        }

        //2.递推公式；
        // 如果第i个物品可以放进背包，就会有两种情况，一种是不放入它的dp[i-1][j]，一种是放入它的dp[i][j-weight[i-1]]+1，两个取最小值
        //4. 遍历顺序，从前往后二维简单
        for (int i = 1; i <dp.length; i++) {
            for (int j = 0; j <dp[0].length; j++) {
                if (j- weight.get(i - 1) >=0){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j- weight.get(i - 1)]+1);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        // 返回的时候注意了
        if (dp[N][bagSize] == Integer.MAX_VALUE-2){
            return 0;
        }
        return dp[N][bagSize];
    }
}
