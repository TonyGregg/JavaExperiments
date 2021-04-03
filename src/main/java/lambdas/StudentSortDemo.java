package lambdas;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StudentSortDemo {
  public static void main(String[] args) {
    ArrayList<Student> studentList = new ArrayList<>();
    Student student = new Student("Antony", "G", "1@1.com", 1);
    studentList.add(student);
    student = new Student("Tony", "B", "2@2.com", 2);
    studentList.add(student);
    student = new Student("Tony", "C", "3@3.com", 2);
    studentList.add(student);
    student = new Student("Tony", "D", "4@4.com", 2);
    studentList.add(student);
    student = new Student("Tony5", "5A", "5A@5.com", 5);
    studentList.add(student);

    List<Student> students =
        studentList.stream()
            .filter(student1 -> student1.getGrade() == 2)
            .sorted(comparing(Student::getLastName))
            .collect(toList());
    System.out.println(students);
  }
}
