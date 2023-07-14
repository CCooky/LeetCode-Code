import java.util.HashMap;
import java.util.Map;

public class 最长斐波那契数列093 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(new 最长斐波那契数列093().getRes(arr));
    }

    public int getRes1(int[] arr) {
        // 先使用dp求
        // dp[i]: 前i个元素中，以第i个元素结尾的最长xx数列长度，为dp[i]。
        int n = arr.length;
        int[] dp = new int[n + 1];
        // dp[i+1] dp[i] 不行做不出来
        return 0;
    }

    /**
     *
     */
    // dp[i][j]：在[0,j]的子数组中，以索引i元素和索引j元素作为最后两个数字的斐波那契子序列的最大长度，i小于j
    // 现在我们已知了序列最后两个元素，那么求dp[i][j]，就需要知道arr[i]前面是否存在符合要求的元素，arr[k]+arr[i]=arr[j]
    // 如果满足，那么 dp[i][j] = Math.max(dp[k][i]+1, 3) 不满足那么就是0. 这里要注意的就是索引k元素要从后往前遍历
    public int getRes(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> map = new HashMap<>(); // 根据元素值获取索引
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int ans = 0;
        for (int j = 2; j < n; j++) {
            for (int i = j - 1; i >= 1; i--) {
                Integer k = map.getOrDefault(arr[j] - arr[i], -1);
                if (k >= 0 && k < i) {
                    dp[i][j] = Math.max(dp[k][i] + 1, 3);
                }
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }

}
