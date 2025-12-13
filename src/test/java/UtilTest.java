import org.example.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilTest {
    @Test
    @DisplayName("yi wang -> Yi Wang")
    void toTitleCase1() {
        String input = "yi wang";
        String actual = Util.toTitleCase(input);
        String expected = "Yi Wang";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("computer science and math -> Computer Science And Math")
    void toTitleCase2() {
        String input = "computer science and math";
        String actual = Util.toTitleCase(input);
        String expected = "Computer Science And Math";
        Assertions.assertEquals(expected, actual);
    }
}
