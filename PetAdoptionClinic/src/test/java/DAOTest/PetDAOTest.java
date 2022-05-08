package DAOTest;

import classes.Sex;
import classes.Species;
import dao.PetDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PetDAOTest {
    static PetDAO petDAO = new PetDAO();

    @Test
    public void TestAddCustomer() {
        petDAO.addPet("Boo", "1", "Short hair", Species.CAT, Sex.FEMALE);
        Assertions.assertEquals(1, petDAO.pets.size());
    }

    @Test
    public void TestEditCustomer() {
        petDAO.addPet("Boo", "1", "Short hair", Species.CAT, Sex.FEMALE);
        petDAO.editPet(1, "name", "1", "12", Species.CAT, Sex.FEMALE);
        Assertions.assertEquals("name", petDAO.pets.get(1).getName());
    }

    @Test
    public void TestRemoveCustomer() {
        petDAO.removePet(1);
        Assertions.assertEquals(1, petDAO.pets.size());
    }
}
