public class LinearSearch {

    private LinearSearch() {
    }

    public static <E> int search(E[] date, E target) {
        for (int i = 0; i < date.length; i++) {
            if (date[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //重写了student的equals方法，才能进行泛型的比较
        Student[] students = {new Student("1",1), new Student("2"),new Student("3")};
        System.out.println(LinearSearch.search(students,new Student("2")));
    }
}
