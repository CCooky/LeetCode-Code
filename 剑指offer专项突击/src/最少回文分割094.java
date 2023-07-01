import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，请将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回符合要求的 最少分割次数 。
 */
public class 最少回文分割094 {
    public static void main(String[] args) {
        new 最少回文分割094().getResByDP("aab");
    }

    public int getRes(String s) {
        backtracking(s, 0);
        if (pathList.size() == 0) return -1;
        int ans = Integer.MAX_VALUE;
        for (List<String> list : pathList) {
            ans = Math.min(ans, list.size() - 1);
        }
        return ans;
    }

    //1、暴力解法：回溯得到所有的具体分割方案
    private List<String> path = new ArrayList<>();
    private List<List<String>> pathList = new ArrayList<>();

    private void backtracking(String s, int startIndex) {
        //2. stop
        if (startIndex == s.length()) {
            pathList.add(new ArrayList<>(path));
            return;
        }
        //3. for + cursion
        for (int i = startIndex; i < s.length(); i++) {
            //
            String substring = s.substring(startIndex, i + 1);
            if (!isPalindrome(substring)) {
                continue;
            }
            path.add(substring);
            //
            backtracking(s, i + 1);
            //
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 解法2:DP
     * 难点是如何定义这个数组
     */
    public int getResByDP(String s) {
        // 我们定义dp[i]: 将前i个字符（[0:i-1]) 分割为若干回文串的最小分割次数，那么最终答案为dp[n]。
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        dp[1] = 0;
        //2.dp[i] 和前面的dp[i-1]关系
        // 如果i个字符是回文的，则直接=0；
        // 如果不是，那么dp[i]和dp[i-1]的关系在于，如后面这段字串如果为回文，则dp[i]=dp[i-1]+1;大概就是这个意思
        // 从右向左依次判断，【left，i-1】（left是索引，left=i-1，left>=1）如果被判断的是回文则，dp[i] = dp[left]+1，并且这里会有多种方案，我们要取最小的;
        // 反正肯定是可以分割的，就是全部为单个字符；
        for (int i = 2; i < dp.length; i++) {
            dp[i] = i - 1;
            if (isPalindrome(s.substring(0, i))) {
                dp[i] = 0;
            } else {
                for (int left = i - 1; left >= 1; left--) {
                    if (isPalindrome(s.substring(left, i))) {
                        dp[i] = Math.min(dp[left] + 1, dp[i]);
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
