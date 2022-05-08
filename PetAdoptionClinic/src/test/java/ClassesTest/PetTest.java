package ClassesTest;



import org.junit.jupiter.api.*;

import classes.Pet;
import classes.Sex;
import classes.Species;

public class PetTest {

	static Pet newPet;
    static Pet pet = new Pet("Boo", "1", "Short hair", Species.CAT, Sex.FEMALE);

    @BeforeEach
    public void PetInit() {
        newPet = new Pet();
    }

    @Test
    public void TestGetName() {
        Assertions.assertEquals("Boo", pet.getName());
    }

    @Test
    public void TestGetAge() {
        Assertions.assertEquals("1", pet.getAge());
    }

    @Test
    public void TestGetBreed() {
        Assertions.assertEquals("Short hair", pet.getBreed());
    }

    @Test
    public void TestGetSpecies() {
        Assertions.assertEquals(Species.CAT, pet.getSpecies());
    }

    @Test
    public void TestGetSex() {
        Assertions.assertEquals(Sex.FEMALE, pet.getSex());
    }

    @Test
    public void TestSetName() {
        newPet.setName("Foo");
        Assertions.assertEquals("Foo", newPet.getName());
    }

    @Test
    public void TestSetAge() {
        newPet.setAge("2");
        Assertions.assertEquals("2", newPet.getAge());
    }

    @Test
    public void TestSetBreed() {
        newPet.setBreed("Long hair");
        Assertions.assertEquals("Long hair", newPet.getBreed());
    }

    @Test
    public void TestSetSpecies() {
        newPet.setSpecies(Species.DOG);
        Assertions.assertEquals(Species.DOG, newPet.getSpecies());
    }

    @Test
    public void TestSetSex() {
        newPet.setSex(Sex.MALE);
        Assertions.assertEquals(Sex.MALE, newPet.getSex());
    }
}
