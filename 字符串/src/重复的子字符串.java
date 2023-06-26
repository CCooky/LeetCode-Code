/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成
 */
public class 重复的子字符串 {

}

class Solution5 {
    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        // 判断ss字符串里面有没有重复出现s
        //要刨除 s + s 的首字符和尾字符，这样避免在s+s中搜索出原来的s，我们要搜索的是中间拼接出来的s。
        String substring = ss.substring(1, ss.length() - 1);
        //boolean result = substring.contains(s);//调用的就是 String.indexOf方法，暴力解法M*N。
        // 模式串匹配的KMP，M+N复杂度。
        boolean result = KMP(substring, s) != -1;
        return result;
    }

    public int KMP(String queryString, String patternString) {
        // 1.简单判断
        if (queryString.length() < patternString.length()) {
            return -1;
        }
        // 2.next前缀表初始化
        int[] next = new int[patternString.length()];
        getNext(next, patternString);
        // 3.开始对比查找
        int j = 0;
        for (int i = 0; i < queryString.length(); i++) {
            while (queryString.charAt(i) != patternString.charAt(j) && j > 0) {
                j = next[j - 1]; //模式串从该字符的前一个字串的最长相等前后缀的索引..
            }
            if (queryString.charAt(i) == patternString.charAt(j)) {
                j++;
            }
            if (j == patternString.length()) {
                return i - patternString.length() + 1;
            }
        }
        return -1;
    }

    public void getNext(int[] next, String s) {
        // i: 后缀的末尾，j：前缀的末尾
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
                next[i] = j;
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                next[i] = j;
            }
        }
    }
}
