import org.example.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DepartmentTest {
    @Test
    @DisplayName("ShO3S --> false")
    void isDepartmentValid1(){
        String department = "Sh0S";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(department);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    @DisplayName("She s --> true")
    void isDepartmentValid2(){
        String department = "She s";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(department);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    @DisplayName("!SHOES --> false")
    void isDepartmentValid3(){
        String department = "!SHOES";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(department);
        Assertions.assertEquals(expected,actual);
    }
}
