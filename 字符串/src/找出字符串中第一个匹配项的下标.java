import java.util.Arrays;

/**
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack字符串中找出 needle字符串的第一个匹配项的下标（下标从0开始）。
 * 如果 needle不是 haystack的一部分，则返回  -1 。
 */
public class 找出字符串中第一个匹配项的下标 {
    public static void main(String[] args) {
        String s = "aabaaf";
        int[] next = new int[s.length()];
        Solution4 solution3 = new Solution4();
        solution3.getNext(next,s);
        System.out.println(Arrays.toString(next));
    }
}

class Solution4 {
    /**
     * 暴力解法
     */
    public static int strStr1(String haystack, String needle) {
        if (!haystack.contains(needle)) {
            return -1;
        }
        return 0;
    }

    /**
     * KMP算法，用到前缀表（不减一）
     * 获取前缀表的算法比较难
     */
    public int strStr(String haystack, String needle) {
        // 1.简单判断
        if (haystack.length()<needle.length()){
            return -1;
        }
        // 2.next前缀表初始化
        int[] next = new int[needle.length()];
        getNext(next,needle);
        // 3.开始对比查找
        int j=0;
        for (int i = 0; i < haystack.length(); i++) {
            while (haystack.charAt(i)!=needle.charAt(j) && j>0 ){
                j = next[j-1]; //模式串从该字符的前一个字串的最长相等前后缀的索引..
            }
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if (j == needle.length()){
                return i-needle.length()+1;
            }
        }
        return -1;
    }

    // 第一步获取模式串的前缀表，这个其实是最难的部分
    public void getNext(int[] next, String s) {
        // i: 后缀的末尾，j：前缀的末尾
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
                next[i] = j;
            }
            if (s.charAt(i) == s.charAt(j)){
                j++;
                next[i] = j;
            }
        }
    }

}
