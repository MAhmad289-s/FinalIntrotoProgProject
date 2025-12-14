import org.example.Address;
import org.example.Course;
import org.example.Department;
import org.example.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CourseTest {
    @Test
    @DisplayName("Assignment weights sum to 100 -> true")
    void isAssignmentWeightValid1() {
        Department department = new Department("Math");
        Course course = new Course("Calculus", 3.0, department);
        course.AddAssignment("Test1", 40, 100);
        course.AddAssignment("Test2", 40, 100);
        boolean actual = course.isAssignmentWeightValid();
        boolean expected = false;
        Assertions.assertEquals(expected, actual);

    }
    @Test
    @DisplayName("Register new student -> true")
    void registerStudent1() {
        Department department = new Department("Math");
        Course course = new Course("Calculus", 3.0, department);
        Address a = new Address(1, "Coolbrooke", "Montreal", Address.Province.Quebec, "hzx4m5");
        Student s = new Student("Yi Wang", Student.Gender.MALE, a, department);
        boolean actual = course.registerStudent(s);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName(" student,  assignment -> average")
    void calcStudentsAverage1() {
        Department d = new Department("Math");
        Course c = new Course(" Linear Algebra", 3.0, d);
        Address a = new Address(1, "Coolbrooke", "Montreal", Address.Province.Quebec, "h435mz");
        Student s = new Student("Yi Wang", Student.Gender.MALE, a, d);
        c.registerStudent(s);
        c.AddAssignment("Test1", 100, 100);
        c.getAssignments().get(0).getScores().set(0, 80);
        int[] actual = c.calcStudentsAverage();
        int[] expected = {80};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    @DisplayName("Add assignment with no students -> 0")
    void addAssignment1() {
        Department department = new Department("CS");
        Course course = new Course("Programming", 3.0, department);
        course.AddAssignment("Assignment1", 25, 100);
        int actual = course.getAssignments().get(0).getScores().size();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }
}
