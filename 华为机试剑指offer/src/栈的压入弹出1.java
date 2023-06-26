import java.util.Stack;

public class 栈的压入弹出1 {
}
class Solution3 {
    public boolean validateStackSequences1(int[] pushed, int[] popped){
        Stack<Integer> stack = new Stack<>();
        int p = 0; //出栈序列的指针
        for (int i = 0; i < pushed.length; i++) {
            //1.先入栈
            stack.push(pushed[i]);
            //2.马上循环判断出栈
            while (true){
                if (stack.peek() == popped[p]){
                    stack.pop();
                    p++;//不用考虑p溢出的问题，因为这两个序列长度一样
                }else break;
                //出栈之后如果栈为空，就stop
                if (stack.isEmpty()) break;
            }
        }
        return stack.isEmpty();
    }
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        //
        Stack<Integer> stack = new Stack<>();
        int point = 0; //出栈的指针
        for (int i = 0; i < pushed.length; i++) {
            //1.先押入
            stack.push(pushed[i]);
            //2.判断相等了就循环出栈！！!直到栈顶元素和出栈序列指针不相同时
            while (!stack.isEmpty() && stack.peek()==popped[point]){ //栈为空时peek会报错
                stack.pop();
                point++;
            }
        }
        return stack.isEmpty();
    }
}
