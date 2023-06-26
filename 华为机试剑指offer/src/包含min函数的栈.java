import java.util.Stack;

public class 包含min函数的栈 {
    public static void main(String[] args) {

    }
}
class Solution30{
    //还是一个栈，至少多了一个功能，可以直接求出栈里面的最小值
    class MinStack {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        /** initialize your data structure here. */
        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            if (stack2.isEmpty()){
                stack2.push(x);
            }else {
                stack2.push(Math.min(stack2.peek(),x));
            }
        }

        public void pop() {
            stack1.pop();
            stack2.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return stack2.peek();
        }
    }
}
