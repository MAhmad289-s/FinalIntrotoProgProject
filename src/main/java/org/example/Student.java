package org.example;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
public class Student {

    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;
    public enum Gender {MALE, FEMALE}

    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);
        return true;
    }
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);
        return true;
    }
    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%05d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }
    public String toSimplifiedString() {
        return studentId + ", " + studentName + ", " + department.getDepartmentName();
    }
    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                '}';
    }
}

