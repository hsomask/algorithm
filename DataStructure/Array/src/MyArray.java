public class MyArray<E> {

    private E[] data;

    private int size; //数组中元素的个数


    // 构造函数，传入数组的容量capacity构造Array
    public MyArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public MyArray() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //数组扩容
    public void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < data.length; i++)
            newArray[i] = data[i];

        data = newArray;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        if (size == data.length)
            resize(2 * data.length);

        //从index位置后进行数据的移动
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;

        //数据增加后，要维护数组的容量
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E getDateByIndex(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        return data[index];
    }

    public E getLast() {
        return getDateByIndex(size - 1);
    }

    public E getFirst() {
        return getDateByIndex(0);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == e)
                return true;
        }
        return false;
    }

    //查找元素的位置
    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e))
                return i;
        }

        return -1;
    }


    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        E temp = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;

        data[size] = null;

        if (size == data.length / 4)
            resize(data.length / 2);


        return temp;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        //先查找元素的位置
        int index = find(e);

        if (index != -1)
            remove(index);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
