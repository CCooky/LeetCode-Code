import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 单词长度的最大乘积005 {


    public int getRes(String[] words) {
        //1. 获取每个字符串含有的字符，使用比特位表示
        int[] bitChar = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int index = words[i].charAt(j) - 'a';
                bitChar[i] |= (1 << index); // 对应比特位置为1（或：有一个1就是1）
            }
        }
        // 依次遍历判断
        int ans = 0;
        boolean flag = true;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bitChar[i] & bitChar[j]) != 0) { //相与不为0，则两个字符串出现了相同的字符

                } else {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
