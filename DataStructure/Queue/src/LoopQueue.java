import com.sun.org.apache.bcel.internal.generic.NEW;

import java.nio.channels.Pipe;
import java.util.Objects;

/**
 * 循环队列
 *
 * @param <E>
 */

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size; //元素个数


    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }


    public int getCapacity() {
        return data.length - 1;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    @Override
    public void enqueue(E e) {

        if ((tail + 1) % data.length == front) {
            resize(this.getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;//循环队列
        size++;
    }

    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            //data[front] 不一定是data[0]
            newData[i] = data[(i + front) % data.length];

            data = newData;
            front = 0;
            tail = size;
            //在这里size不用变，因为没有元素出入队列
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("the queue is empty");

        E res = data[front];

        data[front] = null;
        front = (front + 1) % data.length;

        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return res;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("the queue is empty");
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("Queue: size =%d,capacity=%d \n"), size, getCapacity());
        s.append(" front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            s.append(data[i]);
            if ((i + 1) % data.length != tail)
                s.append(", ");
        }
        s.append("] tail");


        return s.toString();
    }
}
