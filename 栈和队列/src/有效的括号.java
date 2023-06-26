import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class 有效的括号 {
}
class Solution {
    public boolean isValid(String s) {
        // 简单用栈进行配对就行了。如果是左括号类型就压栈
        // 如果是 右括号的话，就出栈，并且判断是否匹配，不匹配就false。或者说
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c=='{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()) return false;
                switch (c){
                    case ')':
                        if(stack.pop() !='(') return false;
                        break;
                    case ']':
                        if(stack.pop() !='[') return false;
                        break;
                    case '}':
                        if(stack.pop() !='{') return false;
                        break;
                }
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}