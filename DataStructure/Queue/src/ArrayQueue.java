public class ArrayQueue<E> implements Queue {

    private MyArray<E> array;

    public ArrayQueue(int capacity) {
        array = new MyArray<>(capacity);
    }

    public ArrayQueue() {
        array = new MyArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    @Override
    public void enqueue(Object o) {

        array.addLast((E) o);

    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Queue: ");
        s.append(" front [");
        for (int i = 0; i < array.getSize(); i++) {
            s.append(array.getDateByIndex(i));
            if (i != array.getSize() - 1)
                s.append(", ");
        }
        s.append("] tail");


        return s.toString();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);

            System.out.println(queue);
        }
    }
}
