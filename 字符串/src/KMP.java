import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String S = "aabaabaaf";
        String str = "aabaaf";
        int index = getIndex(S, str);
        System.out.println(index);
    }

    //S——文本串  str——模式串
    public static int getIndex(String S, String str) {
        int[] next = getNext(str);
        System.out.println(Arrays.toString(next));
        int i = 0, j = 0;
        while (i < S.length() && j < str.length()) {
            if (str.charAt(j) == S.charAt(i)) {
                i++; j++;
            }else {
                // 循环调整 j，直到相等或j=0
                while (j>0 && str.charAt(j)!=S.charAt(i)){
                    j = next[j-1];
                }
                // 判断j=0情况，这里已经是从头开始匹配了，还是不相等的话，就文本串后移一位
                if (str.charAt(j)!=S.charAt(i)){
                    i++;
                }
            }
        }
        if (j==str.length()) {
            return i - str.length();
        }else return -1; //未匹配到
    }

    //获得字符串的前缀表 next数组（模式串）
    // 从前往后每个前缀子串的最长相等前后缀，一共N个子串，和字符串长度一样；
    public static int[] getNext(String s) {
        int[] next = new int[s.length()]; //前缀子串[0,i]的最长相等前后缀长度
        next[0] = 0;
        int j = 0; //j：前缀的末尾
        for (int index = 1; index < s.length(); index++) {
            while (j > 0 && s.charAt(index) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(index) == s.charAt(j)){
                j++;
            }
            next[index] = j; //当前前缀子串的最长相等前后缀长度
        }
        return next;
    }
    //
//    public static int[] getNext(String s) {
//        int[] next = new int[s.length()];
//        int index = 0; //当前前缀子串为[0,index], 求它的最长相等前后缀长度。
//
//    }

}
