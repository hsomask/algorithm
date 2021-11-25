import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列来实现栈
 * 队列：先进先出
 * 栈：先进后出
 * 复杂度为O（1）  不适用临时队列，使用一个元素来记录栈顶元素
 */
public class MyStack2 {

    private Queue<Integer> q;
    private int top;//记录栈顶元素

    public MyStack2() {
        q = new LinkedList<>();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public int getSize() {
        return q.size();
    }

    public void push(int data) {
        q.add(data);
        top = data;//维护栈顶元素
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty.");
        }

        Queue<Integer> temp = new LinkedList<>();
        while (q.size() > 1) {
            //维护栈顶元素
            top=q.peek();
            temp.add(q.remove());
        }
        int res = q.remove();
        //此时将q重新指向tempQueue
        q = temp;
        return res;
    }


    public int getTop() {
        return top;
    }

}





















































