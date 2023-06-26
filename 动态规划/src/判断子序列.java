import java.util.Arrays;

public class 判断子序列 {
}

class Solution39 {
    /**
     * DP做法。就是求两个数组的最长相等子序列的长度，不要求连续啊
     */
    /**
     * 这两个转换太费时间了
     */
    public boolean isSubsequence(String s, String t) {
        //这里是字符串的判断，注意为”“的情况哦，边界条件有三个
        if (s.length()==0) return true;
        if (s.length()!=0 && t.length()==0) return false;
        if (s.length()>t.length()) return false;
        char[] nums1 = s.toCharArray();
        char[] nums2 = t.toCharArray();
        //1.dp数组，使用二维的记录每个元素比较情况
        // dp[i][j]: 数组A中以第i个元素结尾的子序列，和数组B中以第j个元素结尾的子序列，最长重复子数组长度
        int n = nums1.length;
        int k = nums2.length;
        int[][] dp = new int[n + 1][k + 1]; //看dp初始化找到n、k>=0即可

        //3.dp数组初始化
        // 明显需要第一行，但是dp[0][...] 没有意义。dp[1][..]的话，确定不了又，需要用一个for去确定,
        // 使用dp[0][..]试试，看递推公式这里应该为0即可，其实是可以得
        // 哦，还有第一列，也是0吧，没问题
        dp[0][0] = 0;
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        //2.递推公式
        //4.
        int result = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    //dp[i][j] = dp[i-1][j-1] + 1;
                    //这里不需要连续了，那我们就应该在这两个元素前面的所有情况dp，取最大值
                    int max = 0;
                    for (int l = i - 1; l >= 1; l--) { //两个同时减1哦
                        for (int m = j - 1; m >= 1; m--) {
                            max = Math.max(max, dp[l][m]);
                        }
                    }
                    dp[i][j] = max + 1;

                } else {
//                    dp[i][j] = 0;
                    //这里不需要连续了，并且当前两个元素不相等，那么还是一样的啊
                    dp[i][j] = 0;
                }
                // 懒得再写一个for遍历了
                result = Math.max(result, dp[i][j]);
            }
        }
        // 最后应该返回二维数组里面的最大值！，那我们直接在上面两个for得到算了
        return result == s.length();
    }

    /**
     * 非DP做法，一个for循环+一个指针
     */
    public boolean isSubsequence2(String s, String t) {
        if (s.length()==0 && t.length()==0) return false;
        if (s.length()==0 && t.length()!=0) return true;
        if (t.length()==0) return false;
        //暴力
        if (s.length() > t.length()) return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int i=0;
        for (char c1 : chart) {
            if (c1 == chars[i]){ //这个一定先判断
                i++;
            }
            if (i==chars.length){//这个必须放在后面，还蛮有讲究的呢
                return true;
            }
        }
        return false;
    }
}
