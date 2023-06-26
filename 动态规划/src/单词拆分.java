import java.util.*;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class 单词拆分 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wordBreak(s,wordDict);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int[] weight = new int[wordDict.size()]; //每个物品的重量，就是每个单词的长度
        for(int i=0; i<weight.length; i++){
            weight[i] = wordDict.get(i).length();
        }
        //完全背包问题，求能否装满。可以求装满的方案数
        //dp[j]:容量为j的背包，能否被装满。求dp[s.length()],容量就是s的长度，但并不是凑满长度就好了，还要判断是否相等
        int bagSize = s.length();
        int n = wordDict.size();
        boolean[] dp = new boolean[bagSize+1];

        dp[0] = true;

        //2.dp[j]= dp[j];
        // dp[j] = dp[j] || ( dp[j-weight[i-1]] & wordDict.get(i-1).equals(s.subString(j-weight[i-1], j)) ); //后一个判断两个都为true时，才能被装满
        // 第i个物品能否放下
        for(int j=1; j<dp.length; j++){
            for(int i=1; i<=n; i++){
                if(j-weight[i-1]>=0){
                    dp[j] = dp[j] || ( dp[j-weight[i-1]] && wordDict.get(i-1).equals(s.substring(j-weight[i-1], j)) );
                }else{
                    dp[j]= dp[j];
                }
            }
        }

        return dp[bagSize];
    }
}
class Solution23 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int bagSize = s.length(); // 背包容量
        int n = wordDict.size(); //物品个数
        //物品重量数组
        int[] weight = new int[n];
        Set<String> wordSet = new HashSet<>(wordDict);
        for (int i = 0; i < wordDict.size(); i++) {
            weight[i] = wordDict.get(i).length();
        }
        //1.dp 长度为j的字符串，能否被字典里单词填满。
        boolean[] dp = new boolean[bagSize+1];
        //3.dp初始化.从0个物品数量选
        Arrays.fill(dp,false);
        dp[0] = true;

        //2.
        //4.完全背包之排列情况。先背包后物品
        for (int j = 1; j <dp.length; j++) { //正序一维背包
            for (int i = 1; i <=n; i++) {
                if (j-weight[i-1]>=0){
                    String s1 = s.substring(j - weight[i - 1], j);
                    dp[j] = dp[j] || (dp[j-weight[i-1]] && wordSet.contains(s1));
                }else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[bagSize];
    }
}
