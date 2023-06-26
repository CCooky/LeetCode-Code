public class 一和零 {
}
class Solution88{

    public int getRes(String[] str, int m, int n){
        if (str.length==0) return 0;
        // 每个物品有两个维度，一个是1的数量，一个是0的数量，我们提前处理一下
        int[] weight0 = new int[str.length];
        int[] weight1 = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            int num0 = 0, num1 = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j)=='0') num0++;
                else num1++;
            }
            weight0[i] = num0;
            weight1[i] = num1;
        }
        int N = str.length;
        //d[i][j][k]: 从i个物品选，容量为i和j的背包，最多装多少个物品；求dp[N][m][n]
        int[][][] dp = new int[N+1][m+1][n+1];

        //3.初始化dp[0][..][..] ，根据推导全部为0即可
        dp[0][0][0] = 0;

        //2.dp[i][j][k]: 第i个物品能不能放下
        // dp[i][j][k] = dp[i-1][j][k]
        // dp[i][j][k] = Math.max( dp[i-1][j-weight0[i-1]][k-weight1[i-1]] + 1, dp[i-1][j][k] )
        for (int i = 1; i <dp.length; i++) {
            for (int j = 0; j <dp[0].length; j++) {
                for (int k = 0; k <dp[0][0].length; k++) {
                    if (j-weight0[i-1]>=0 && k-weight1[i-1]>=0){
                        dp[i][j][k] = Math.max( dp[i-1][j-weight0[i-1]][k-weight1[i-1]] + 1, dp[i-1][j][k] );
                    }else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }

        return dp[N][m][n];
    }
}
