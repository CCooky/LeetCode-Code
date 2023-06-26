import java.util.Stack;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 */
public class 逆波兰表达式求值 {
}

class Solution3 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int pop1;
        int pop2;
        Integer res;
        // 数字全部入栈即可，遇到算术符号即取出栈顶的两个元素，下面的运算栈顶的，算完压栈
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    res = pop2 + pop1;
                    stack.push(res);
                }
                case "-" -> {
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    res = pop2 - pop1;
                    stack.push(res);
                }
                case "*" -> {
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    res = pop2 * pop1;
                    stack.push(res);
                }
                case "/" -> {
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    res = pop2 / pop1;
                    stack.push(res);
                }
                default -> stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
