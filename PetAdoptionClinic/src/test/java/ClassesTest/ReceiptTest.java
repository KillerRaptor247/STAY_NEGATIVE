package ClassesTest;

import classes.Employee;
import classes.Reciept;
import classes.Sale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReceiptTest {

    Sale sale = new Sale(PetTest.pet, CustomerTester.customer, EmployeeTest.employee, "2020/5/1");
    Reciept reciept = new Reciept(sale);

    @Test
    public void TestGetSale() {
        Assertions.assertEquals("2020/5/1", reciept.getSale().getDateAdopted());
    }
}
