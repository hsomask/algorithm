/**
 * 双向队列
 * 可以在头尾都删除和插入数据
 *
 * @param <E>
 */

public class Deque<E> {
    private E[] data;
    private int front, tail;
    private int size;  //存储的元素的个数

    public Deque(int capacity) {   //
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;

    }

    public Deque() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }


    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[(i + front) / data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    public void addLast(E e) {

        if (size == getCapacity())
            resize(getCapacity() * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }


    /**
     * 循环队列，要考虑front的位置
     *
     * @param e
     */
    public void addFront(E e) {
        if (size == getCapacity())
            resize(getCapacity() * 2);

        //头部的位置，如果front==0,这时候front=data.length - 1
        //如果不等于0，就为front-1
        front = front == 0 ? data.length - 1 : front - 1;

        data[front] = e;
        size++;
    }

    //先进先出
    public E removeFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot remove from an empty queue.");

        E res = data[front];
        data[front] = null;

        front = (front + 1) / data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);

        return res;
    }

    public E removeLast() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot remove from an empty queue.");

        tail = tail == 0 ? data.length - 1 : tail - 1;

        E ret = data[tail];
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        size--;
        return ret;

    }

    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot remove from an empty queue.");

        return data[front];
    }

    public E getLast() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot remove from an empty queue.");
        // 因为 tail 指向的是队尾元素的下一个位置，我们需要计算一下真正队尾元素的索引
        int index = tail == 0 ? data.length - 1 : tail - 1;
        return data[index];
    }

    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");

        // 注意，我们的循环遍历打印队列的逻辑也有相应的更改 :-)
        for (int i = 0; i < size; i++) {
            res.append(data[(front + i) % data.length]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }


}
