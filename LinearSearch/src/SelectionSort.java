import javax.swing.text.DefaultStyledDocument;

/**
 * 选择排序
 */

public class SelectionSort {
    private SelectionSort() {
    }

    public static void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int tempValue = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tempValue;
        }
    }

    public static <E extends Comparable<E>> void eSort(E[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            E tempValue = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tempValue;
        }
    }

    public static void main(String[] args) {
//        int[] a = {2, 3, 5, 1, 9, 98, 10, 100, 16, 76, 55};
//        SelectionSort.sort(a);
//        for (int i : a) {
//            System.out.print(i + "  ");
//        }

        Student[] students = {new Student("2", 1),
                new Student("1", 2),
                new Student("3", 3)};

        eSort(students);

       for(Student student:students){
           //覆盖了studnet的  tostring方法。才能打印出来
           System.out.println(student);
       }

    }
}
