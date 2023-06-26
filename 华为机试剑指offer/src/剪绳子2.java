public class 剪绳子2 {
}
class Solution16 {
    public int cuttingRope(int n) {
        if (n<2) return -1;
        long[] dp = new long[n+1]; //long
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            for (int j = 1; j < n; j++) {
                dp[i] = (long) (Math.max( dp[i]%(1e9+7),
                        Math.max((long) j *(i-j), j*dp[i-j])%(1e9+7) )%(1e9+7));
            }
        }
        return (int)dp[n];
    }
}
