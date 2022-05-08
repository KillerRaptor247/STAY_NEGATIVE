package DAOTest;

import classes.Sex;
import classes.Species;
import dao.PetDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PetDAOTest {
    static PetDAO petDAO = new PetDAO();

    @BeforeEach
    public void reset() {
    	petDAO.pets.clear();
    }
    @Test
    public void TestAddPet() {
        petDAO.addPet("Boo", "1", "Short hair", Species.CAT, Sex.FEMALE);
        Assertions.assertEquals(1, petDAO.pets.size());
    }

    @Test
    public void TestEditPet() {
        petDAO.addPet("Boo", "1", "Short hair", Species.CAT, Sex.FEMALE);
        petDAO.editPet(1, "name", "1", "12", Species.CAT, Sex.FEMALE);
        Assertions.assertEquals("name", petDAO.pets.get(1).getName());
    }

    @Test
    public void TestRemovePet() {
        petDAO.removePet(1);
        Assertions.assertEquals(0, petDAO.pets.size());
    }
}
