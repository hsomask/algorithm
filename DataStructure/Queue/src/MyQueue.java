import java.util.Stack;

/**
 * 用栈实现队列
 */
public class MyQueue {

    private Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getSize() {
        return stack.size();
    }

    /**
     * 约定栈顶为队首
     */
    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

}
