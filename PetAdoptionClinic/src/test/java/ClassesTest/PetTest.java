package ClassesTest;

import classes.Pet;
import classes.Sex;
import classes.Species;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PetTest {

    static Pet pet = new Pet("Boo", "1", "Short hair", Species.CAT, Sex.FEMALE);

    @BeforeEach
    static void PetInit() {
        Pet newPet = new Pet();
    }

    @Test
    static void TestGetName() {
        Assertions.assertEquals("Boo", pet.getName());
    }

    @Test
    static void TestGetAge() {
        Assertions.assertEquals("1", pet.getAge());
    }

    @Test
    static void TestGetBreed() {
        Assertions.assertEquals("Short hair", pet.getBreed());
    }

    @Test
    static void TestGetSpecies() {
        Assertions.assertEquals(Species.CAT, pet.getSpecies());
    }

    @Test
    static void TestGetSex() {
        Assertions.assertEquals(Sex.FEMALE, pet.getSex());
    }

    @Test
    static void TestSetName() {
        newPet.setName("Foo");
        Assertions.assertEquals("Foo", newPet.getName());
    }

    @Test
    static void TestSetAge() {
        newPet.setAge("2");
        Assertions.assertEquals("2", newPet.getAge());
    }

    @Test
    static void TestSetBreed() {
        newPet.setBreed("Long hair");
        Assertions.assertEquals("Long hair", newPet.getBreed());
    }

    @Test
    static void TestSetSpecies() {
        newPet.setSpecies(Species.DOG);
        Assertions.assertEquals(Species.DOG, newPet.getSpecies());
    }

    @Test
    static void TestSetSex() {
        newPet.setSex(Sex.MALE);
        Assertions.assertEquals(Sex.MALE, newPet.getSex());
    }
}
