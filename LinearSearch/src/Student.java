import java.util.Objects;
import java.util.Stack;

public class Student implements Comparable<Student> {

    private String name;

    private int score;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }


    @Override
    public int compareTo(Student student) {

//        if (this.score < student.score) {
//            return -1;
//        } else if (this.score == student.score) {
//            return 0;
//        }
//
//        return 1;

        return this.score - student.score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("Student(name : %s ,score :%d)", this.name, this.score);
    }



    Stack<Integer> stack=new Stack<>();
}
