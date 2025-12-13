import org.example.Address;
import org.example.Course;
import org.example.Department;
import org.example.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CourseTest {
    @Test
    @DisplayName("Register new student -> true")
    void registerStudent1() {
        Department department = new Department("Math");
        Course course = new Course("Calculus", 3.0, department);
        Address a = new Address(1, "Main St", "Toronto", Address.Province.Quebec, "hzx4m5");
        Student s = new Student("John Doe", Student.Gender.MALE, a, department);
        boolean actual = course.registerStudent(s);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Single student, single assignment -> correct weighted average")
    void calcStudentsAverage1() {
        Department d = new Department("Math");
        Course c = new Course("Algebra", 3.0, d);
        Address a = new Address(1, "Main St", "Toronto", Address.Province.Quebec, "A1B2C3");
        Student s = new Student("John Doe", Student.Gender.MALE, a, d);
        c.registerStudent(s);
        c.addAssignment("Test1", 100, 100);
        c.getAssignments().get(0).getScores().set(0, 80);
        int[] actual = c.calcStudentsAverage();
        int[] expected = {80};
        Assertions.assertArrayEquals(expected, actual);
    }

}
