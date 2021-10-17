import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:hsoluo
 * @date 2021/8/6 16:03
 * <p>
 * 使用数组实现队列
 * 1.入队
 * 2.出队
 * 3.查询队列长度
 * 4.获取长度为x的一个队列
 */

public class Queue {

    private String[] queue;

    //数组大小
    private int n;

    //头部指针
    private int head = 0;

    //尾部指针
    private int tail = 0;

    //获取一个长度为length的队列
    public String[] getQueue(int length) {
        queue = new String[length];
        n = length;
        return queue;
    }


    //队列入队相当于虫虫尾巴增长
    //队列出队相当于虫虫的头往后缩

    //入队
    public boolean enQueue(String item) {
        //队列已满，不能再入队
        if (tail == n) {
            System.out.println("队列已满，不能再插入队列");
            return false;
        }
        //队列没有满
        queue[tail] = item;
        ++tail;
        return true;
    }

    //出队
    public String deQueue() {
        if (head == n) {
            System.out.println("队列为空，无数据返回");
            return null;
        }
        String res = queue[head];
        ++head;
        return res;
    }


}


/**
 * 无锁并发环形队列
 * 无锁并发主要基于CAS原理
 */


class ConcurrentLoopQueue {

    private int capacity;

    private AtomicInteger head;

    private AtomicInteger tail;

    private volatile Integer[] array;


    public ConcurrentLoopQueue(int capacity) {
        this.capacity = capacity;
        array = new Integer[capacity];
        head = new AtomicInteger(0);
        tail = new AtomicInteger(0);
    }


    public boolean enqueue(Integer num) {
        boolean flag = false;
        int preTail = 0;
        int nextTail = 0;


        /**
         * flag是无限循环，直至enqueue成功
         * 1.取得当前值
         * 2.计算+1后的值
         * 3.如果当前值还有效(没有被其他线程改过)的话设置那个+1后的值
         * 4.如果设置没成功(当前值已经无效了即被别的线程改过了), 再从1开始.
         *
         *
         *
         * CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。
         * 当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。
         */

        while (!flag) {
            preTail = tail.get();
            if ((preTail + 1) % capacity == head.get()) { //队列已满
                System.out.println("队列已满，不能再插入队列");
                return false;
            }
            nextTail = (preTail + 1) % capacity;

            //实现操作原子性
            if (tail.compareAndSet(preTail, nextTail)) {
                array[preTail] = num;
                return true;
            }
        }
        return false;


    }

    public Integer dequeue() {
        int preHead = 0;
        int nextHead = 0;
        boolean flag = false;
        if (!flag) {
            preHead = head.get();
            if (preHead == tail.get()) {//队列为空
                System.out.println("队列为空，无数据返回");
                return null;

            }
            nextHead = (preHead + 1) % capacity;
            if (head.compareAndSet(preHead, nextHead)) {
                return array[preHead];

            }
        }
        return null;
    }


}