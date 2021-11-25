import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列来实现栈
 * 队列：先进先出
 * 栈：先进后出
 * 复杂度为O（n）
 */
public class MyStack {
    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public int getSize() {
        return q.size();
    }

    /**
     * 假设队列入队的为栈顶
     * 直接入栈
     *
     * @param data
     */
    public void push(int data) {
        q.add(data);
    }

    /**
     * 出栈
     * 栈的出栈就是要拿到栈顶的元素
     * 相对于队列来说，就是要拿到队尾的元素
     * <p>
     * 实现方法1：使用临时队列来存储n-1的数据，取出队尾元素
     */

    public int pop() {
        if(isEmpty()){
            throw new IllegalArgumentException("queue is empty.");
        }

        Queue<Integer> tempQueue = new LinkedList<>();
        //执行完这个循环后，q只剩下队尾的最后一个元素了
        while (q.size() > 1) {
            tempQueue.add(q.remove());
        }
        int res = q.remove();
        //此时将q重新指向tempQueue
        q = tempQueue;
        return res;
    }

    /**
     * 获取栈顶元素(不删除栈顶的元素)
     * 参考出栈的方法1
     */

    public int getTop() {
//me:
//        Queue<Integer> tempQueue = new LinkedList<>();
//        while (q.size() > 1) {
//            tempQueue.add(q.remove());
//        }
//        int res = q.remove();
//        tempQueue.add(res);
//        q = tempQueue;
//        return res;
//---------------------------------两者的实现思路是一样的，只是下面的利用了已有的方法
//teacher:
        int res = pop();
        push(res);
        return res;
    }


}
