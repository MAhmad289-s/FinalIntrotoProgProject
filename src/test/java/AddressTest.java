import org.example.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddressTest {
    @Test
    @DisplayName("A1B2C3 -> true")
    void isPostalCodeValid1(){
        String postalCode = "A1B2C3";
        boolean actual = Address.isPostalCodeValid(postalCode);
        boolean expected = true;
        Assertions.assertEquals(expected,actual);
    }
    @Test
    @DisplayName("11B2C3 -> false")
    void isPostalCodeValid2(){
        String postalCode = "11B2C3";
        boolean actual = Address.isPostalCodeValid(postalCode);
        boolean expected = false;
        Assertions.assertEquals(expected,actual);
    }
    @Test
    @DisplayName("A1B2C3D4-> false")
    void isPostalCodValid2(){
        String postalCode = "A1B2C3D4";
        boolean actual = Address.isPostalCodeValid(postalCode);
        boolean expected = false;
        Assertions.assertEquals(expected,actual);
    }
}
