import java.util.HashSet;
import java.util.Stack;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，
 * 并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class 删除字符串中的所有相邻重复项 {
    public static void main(String[] args) {
        String s = "abbaca";
        Solution1 solution1 = new Solution1();
        solution1.removeDuplicates(s);
    }

}
class Solution1{
    // 这个要仔细思考用什么数据结构才行，递归方法里面一定不要new东西
    HashSet<String> hashSet = new HashSet<>();
    // 很明显啊，要递归删除
    public String removeDuplicates(String s){
        if (hashSet.contains(s)){
            return s;
        }else {
            hashSet.add(s);
        }
        char[] chars = s.toCharArray();
        // 双指针呀，可以，指向相邻的两个元素
        StringBuilder stringBuilder = new StringBuilder();
        int left = 0;
        int right = 1;
        while (left<chars.length){
            if (left == chars.length-1){
                stringBuilder.append(chars[left]);
                left++;
            }
            else if (chars[right] == chars[left]){
                right = right +2;
                left = left +2;
            }else {
                stringBuilder.append(chars[left]);
                left++;
                right++;
            }
        }
        String s1 = stringBuilder.toString();
        return removeDuplicates(s1);
    }

    public String removeDuplicates2(String s){
        // 只能用栈来解决，一个for循环，无递归。想到递归就要想到栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || s.charAt(i)!=stack.peek()){
                stack.push(s.charAt(i));
            }else {
                stack.pop();
            }
        }
        // 栈内剩下的就是字符串
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.insert(0, stack.pop());
        }
        return res.toString();


    }

}
