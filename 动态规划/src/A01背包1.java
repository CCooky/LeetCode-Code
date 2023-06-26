import java.util.Arrays;

public class A01背包1 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        Solution9 solution9 = new Solution9();
        solution9.testWeightBagProblem3(weight, value, bagSize);
    }
}

class Solution9 {
    /**
     * 动态规划获得结果
     */
    public void testWeightBagProblem(int[] weight, int[] value, int bagSize) {

        // 创建dp数组
        int N = weight.length;  // 获取物品的数量
        int K = bagSize;
        int[][] dp = new int[N + 1][K + 1]; //从给的N个物品内选取，背包大小为K，能放下的最大价值

        // 初始化dp数组
        // 1.dp[i][j]；第1行表示，从0个物品选取，肯定值为0
        // 2.第1列表示：从N个物品选，背包大小为0，肯定为0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        Arrays.fill(dp[0], 0);

        // 填充dp数组
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j-weight[i-1]>=0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]] + value[i-1]);  //j-weight[i-1]这里要判断,不然这个值小于0的话，就会出现数组索引越界，但逻辑上我们肯定是没有这一步的
                }
                if (j-weight[i-1]<0){
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    /**
     * 状态压缩：将二维的压缩到一维数组，
     * 且需要注意的是第二层的循环我们需要从大到小计算，因为如果我们从小到大更新 dp 值，
     * 那么在计算 dp[j] 值的时候，dp[j−nums[i]]已经是被更新过的状态，不再是上一行的 dp值。
     */
    public void testWeightBagProblem2(int[] weight, int[] value, int bagSize) {

        // 创建dp数组
        int N = weight.length;  // 获取物品的数量
        int K = bagSize;
        int[] dp = new int[K+1]; //最后求的时 dp[k].[0,..K]
        //3.
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 0;
        }
        //2.
        for (int i = 1; i <= N; i++) { //先遍历物品
            for (int j = dp.length-1; j >=0 ; j--) { // 遍历背包 dp
                if (j-weight[i-1]>=0){
                    dp[j] = Math.max(dp[j], dp[j-weight[i-1]] + value[i-1]);
                }else {
                    dp[j] = dp[j];
                }
            }
        }
        //打印dp数组
        for (int j = 0; j < dp.length; j++){
            System.out.print(dp[j] + " ");
        }
    }

    public void testWeightBagProblem3(int[] weight, int[] value, int bagWeight){
        int wLen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < wLen; i++){
            for (int j = bagWeight; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }
    }

}

