import java.util.Arrays;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class 替换空格 {
    public static void main(String[] args) {
        String s = "we;are;;good";
        String[] s1 = s.split(";");
        System.out.println(Arrays.toString(s1));
        System.out.println(s1[3].length());
    }
}
class Solution1{
    /**
     * 第一种，使用空格进行分割符号拆分字符串。但是有问题，假如连续两个空格呢？
     * 第二种，for循环，遇到空格就拼接%20，用stringbuilder拼接
     */
    public String replaceSpace(String s){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
