import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 */
public class 反转字符串中的单词 {
    public static void main(String[] args) {
        String s = "  hello world  ";
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.reverseWords2(s));
    }
}

class Solution2 {
    /**
     * 调用库的解法。。。可能面试会要你不掉库
     * String.split() +StringBuilder.append() + StringBuilder.delete...
     */
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].equals("")){

            }else { //这样的话，尾巴处一定是多一个空格
                stringBuilder.append(split[i]);
                stringBuilder.append(" ");
            }
        }
        //处理尾处的空格
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
    /**
     * 算法的方式解
     * 其实就是单独找出每个单词先，然后拼起来，可以用List
     */
    public String reverseWords2(String s){
        List<String> list  = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=' '){
                StringBuilder stringBuilder = new StringBuilder();
                for (; i <s.length() ; i++) {
                    if (s.charAt(i)!=' '){
                        stringBuilder.append(s.charAt(i));
                    }else {
                        break;
                    }
                }
                //
                list.add(stringBuilder.toString());
            }
            //
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size()-1; i >=0 ; i--) {
            stringBuilder.append(list.get(i));
            stringBuilder.append(' ');
        }
        //处理尾处的空格
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();


    }
















}
