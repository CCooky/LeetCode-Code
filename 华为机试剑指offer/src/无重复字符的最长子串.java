import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        getRes(s);
    }

    //
    public static int getRes(String s) {
        //使用一个Set记录窗口内的所有元素，来判断是否重复
        char[] chars = s.toCharArray();
        int left = 0;
        int MaxLen = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {// i——结束位置
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                MaxLen = Math.max(MaxLen, i - left + 1);
            } else {
                //这里需要一直移动到，left指针满足要求的位置
                while (set.contains(chars[i])) {
                    //重复了, left应该移动当前窗口满足要求的位置
                    set.remove(chars[left]); //remove此时左指针所在字符
                    left++;
                }
                set.add(chars[i]);
            }
        }
//        System.out.println(MaxLen);
        return MaxLen;
    }
}
