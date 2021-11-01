public class InsertSelection {
    public InsertSelection(){}

    public static <T extends Comparable<T>> T[] insertSort(T[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            T t = arr[i];
            int j;
            for (j = i; j + 1 < arr.length&&t.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }
        return arr;
    }
}
