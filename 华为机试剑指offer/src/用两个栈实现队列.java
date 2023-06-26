import java.util.Stack;

public class 用两个栈实现队列 {
    public static void main(String[] args) {

    }
}
class CQueue{

    private Stack<Integer> stack1; //插入的时候放入这个
    private Stack<Integer> stack2; //删除时先找2是不是有元素，有的话就直接pop，没有的话就先把1倒入，再pop

    public CQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value){
        stack1.push(value);
    }

    public int deleteHead(){
        //1.先看2有没有元素
        if (!stack2.isEmpty()) return stack2.pop();
        //2.没有的话就先把1倒入，再pop
        if (stack1.isEmpty()) return -1;
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
