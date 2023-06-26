import java.util.Arrays;

public class 完全背包问题 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        solution15.testCompletePack2();
    }
}
class Solution15{
    // 纯完全背包问题，保证背包正序遍历，两个for无所谓
    public void testCompletePack(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++){ // 遍历物品
            for (int j = weight[i]; j <= bagWeight; j++){ // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int maxValue : dp){
            System.out.print(maxValue + "   ");
        }
    }

    public void testCompletePack2(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;

        int[][] dp = new int[weight.length+1][bagWeight + 1];

        dp[0][0] = 0;
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 100;
        }
        for (int i = 1; i <= weight.length; i++){ // 遍历物品
            for (int j = 0; j < bagWeight+1; j++){ // 遍历背包容量
                if (j-weight[i-1]>=0){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-weight[i-1]] + value[i-1]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
