import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 最长不含重复字符的子字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        getRes(s);
    }

    // for + while
    public static int getRes(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();

        int left = 0;
        int Maxlen = 0;
        for (int i = 0; i < n; i++) { //结束位置
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                Maxlen = Math.max(i - left + 1, Maxlen);
            } else {
                //此时i索引元素没有加入滑动窗口，先将左指针移动到合适位置
                while (set.contains(chars[i])) {
                    set.remove(chars[left]);
                    left++;
                }
                set.add(chars[i]);
                Maxlen = Math.max(i - left + 1, Maxlen);
            }
        }
        System.out.println(Maxlen);
        return Maxlen;


    }
}
