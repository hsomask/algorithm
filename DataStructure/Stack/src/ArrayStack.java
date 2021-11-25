/**
 * *动态栈
 * 用动态数组实现栈
 */
public class ArrayStack<E> implements Stack<E> {

    MyArray<E> array;

    public ArrayStack(int capacity) {
        array = new MyArray(capacity);
    }

    //默认capacity 为10
    public ArrayStack() {
        array = new MyArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public void push(E e) {

        array.addLast(e);
    }


    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("Stack: ");
        s.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            s.append(array.getDateByIndex(i));
            if (i != array.getSize() - 1)
                s.append(", ");
        }
        s.append("] top");


        return s.toString();

    }
}
