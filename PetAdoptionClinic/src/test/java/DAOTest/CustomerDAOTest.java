package DAOTest;

import dao.CustomerDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerDAOTest {

    static CustomerDAO customerDAO;
    
    @BeforeEach
    public void reset() {
    	customerDAO = new CustomerDAO();
    	customerDAO.customers.clear();
    }

    @Test
    public void TestAddCustomer() {
        customerDAO.addCustomer("Name", "123 Baylor Street", "12", "123321", "123321", "name@baylor.edu");
        Assertions.assertEquals(1, customerDAO.customers.size());
    }

    @Test
    public void TestEditCustomer() {
        customerDAO.addCustomer("Name", "123 Baylor Street", "12", "123321", "123321", "name@baylor.edu");
        customerDAO.editCustomer(1, "name", "123 Baylor Street", "12", "123321", "123321", "name@baylor.edu");
        Assertions.assertEquals("name", customerDAO.customers.get(1).getName());
    }

    @Test
    public void TestRemoveCustomer() {
        customerDAO.removeCustomer(1);
        Assertions.assertEquals(0, customerDAO.customers.size());
    }
}
