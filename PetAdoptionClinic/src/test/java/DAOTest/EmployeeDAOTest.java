package DAOTest;

import dao.EmployeeDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeDAOTest {

    static EmployeeDAO employeeDAO = new EmployeeDAO();
    
    @BeforeEach
    public void reset() {
    	employeeDAO.employees.clear();
    }

    @Test
    public void TestAddEmployee() {
        employeeDAO.addEmployee("Name", "123 Baylor Street", "12", "123321", "123321", "name@baylor.edu", true);
        Assertions.assertEquals(1, employeeDAO.employees.size());
    }

    @Test
    public void TestEditEmployee() {
        employeeDAO.addEmployee("Name", "123 Baylor Street", "12", "123321", "123321", "name@baylor.edu", true);
        employeeDAO.editEmployee(1, "name", "123 Baylor Street", "12", "123321", "123321", "name@baylor.edu", true);
        Assertions.assertEquals("name", employeeDAO.employees.get(1).getName());
    }

    @Test
    public void TestRemoveEmployee() {
        employeeDAO.removeEmployee(1);
        Assertions.assertEquals(0, employeeDAO.employees.size());
    }
}
