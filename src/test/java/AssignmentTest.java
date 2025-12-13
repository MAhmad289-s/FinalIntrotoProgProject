import org.example.Course;
import org.example.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssignmentTest {
    @Test
    @DisplayName("Assignment weights sum to 100 -> true")
    void isAssignmentWeightValid2() {
        Department department = new Department("Math");
        Course course = new Course("Calculus", 3.0, department);

        course.addAssignment("Test1", 40, 100);
        course.addAssignment("Test2", 40, 100);
        boolean actual = course.isAssignmentWeightValid();
        boolean expected = false;

        Assertions.assertEquals(expected, actual);

    }
}
