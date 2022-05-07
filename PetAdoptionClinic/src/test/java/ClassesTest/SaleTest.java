package ClassesTest;

import classes.Customer;
import classes.Employee;
import classes.Pet;
import classes.Sale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SaleTest {

    static Pet p = new Pet();
    static Customer c = new Customer();
    static Employee e = new Employee();
    static Sale sale = new Sale(p, c, e, "2020/5/1");

    @BeforeEach
    static void init() {
        p.setName("Boo");
        c.setName("Customer");
        e.setName("Employee");
    }

    @Test
    static void TestGetDateAdopted() {
        Assertions.assertEquals("2020/5/1", sale.getDateAdopted());
    }

    @Test
    static void TestGetCustomer() {
        sale.setCustomer(c);
        Assertions.assertEquals("Customer", sale.getCustomer().getName());
    }

    @Test
    static void TestGetEmployee() {
        sale.setEmployee(e);
        Assertions.assertEquals("Employee", sale.getEmployee().getName());
    }

}
