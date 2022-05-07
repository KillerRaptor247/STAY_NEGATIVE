package ClassesTest;

import classes.Customer;
import org.junit.jupiter.api.*;


public class CustomerTester {
    static Customer testCus;

    static Customer customer = new Customer("Name", "123 Baylor Street", "12", "123321", "123321", "name@baylor.edu");

    @BeforeEach
    static void CustomerInit() {
        Customer testCus = new Customer();
    }

    @Test
    static void testGetName() {
        Assertions.assertEquals("Name", customer.getName());
    }

    @Test
    static void testGetAddress() {
        Assertions.assertEquals("123 Baylor Street", customer.getAddress());
    }

    @Test
    static void testGetAge() {
        Assertions.assertEquals("12", customer.getAge());
    }

    @Test
    static void testGetUsername() {
        Assertions.assertEquals("123321", customer.getUsername());
    }

    @Test
    static void testGetPassword() {
        Assertions.assertEquals("123321", customer.getPassword());
    }

    @Test
    static void testGetEmail() {
        Assertions.assertEquals("name@baylor.edu", customer.getEmail());
    }

    @Test
    static void testSetName() {
        testCus.setName("test");
        Assertions.assertEquals("test", testCus.getName());
    }

    @Test
    static void testSetAddress() {
        testCus.setAddress("321 Baylor Street");
        Assertions.assertEquals("321 Baylor Street", testCus.getAddress());
    }

    @Test
    static void testSetAge() {
        testCus.setAge("21");
        Assertions.assertEquals("21", testCus.getAge());
    }

    @Test
    static void testSetUsername() {
        testCus.setUsername("321123");
        Assertions.assertEquals("321123", testCus.getUsername());
    }

    @Test
    static void testSetPassword() {
        testCus.setPassword("321123");
        Assertions.assertEquals("321123", testCus.getPassword());
    }

    @Test
    static void testSetEmail() {
        testCus.setEmail("test@baylor.edu");
        Assertions.assertEquals("test@baylor.edu", testCus.getEmail());
    }
}
