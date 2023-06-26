import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。
 * 队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 */
public class 用栈实现队列 {
}

class MyQueue {
    // s1 用来存放数据，每次操作完数据全部放到这里面
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x); //自动装箱
    }

    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        Integer pop = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return pop;
    }

    public int peek() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        Integer peek = stack2.peek();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return peek;

    }

    public boolean empty() {
        return stack1.empty();
    }
}
