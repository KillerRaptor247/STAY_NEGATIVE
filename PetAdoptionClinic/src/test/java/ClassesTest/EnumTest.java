package ClassesTest;

import classes.Sex;
import classes.Species;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnumTest {

    @Test
    public void TestSex() {
        Assertions.assertEquals("Male", Sex.MALE.toString());
    }

    @Test
    public void TestSpecies() {
        Assertions.assertEquals("Cat", Species.CAT.toString());
    }
}
