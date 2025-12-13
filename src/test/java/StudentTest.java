import org.example.Address;
import org.example.Course;
import org.example.Department;
import org.example.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public  class StudentTest {
    @Test
    @DisplayName("Computer Science -> true")
    void isDepartmentNameValid1() {
        String name = "Computer Scienct";
        boolean actual = Department.isDepartmentNameValid(name);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Empty string ----> false")
    void isDepartmentNameValid2() {
        String name = "";
        boolean actual = Department.isDepartmentNameValid(name);
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }
}
