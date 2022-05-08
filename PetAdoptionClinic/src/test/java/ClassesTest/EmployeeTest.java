package ClassesTest;

import classes.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    static Employee employee = new Employee("Name", "123 Baylor Street", "12", "123321", "123321", "name@baylor.edu", true);

    @Test
    public void TestIsManager() {
        Assertions.assertTrue(employee.isManager());
    }

    @Test
    public void TestSetManager() {
        Employee employee1 = new Employee();
        employee1.setManager(true);
        Assertions.assertTrue(employee1.isManager());
    }
}
