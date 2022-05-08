package ClassesTest;

import org.junit.jupiter.api.*;

import classes.Customer;


public class CustomerTester {
    static Customer testCus;

    static Customer customer = new Customer("Name", "123 Baylor Street", "12", "123321", "123321", "name@baylor.edu");
    
    @BeforeEach
    public void CustomerInit() {
        testCus = new Customer();
    }

    @Test
    public void testGetName() {
        Assertions.assertEquals("Name", customer.getName());
    }

    @Test
    public void testGetAddress() {
        Assertions.assertEquals("123 Baylor Street", customer.getAddress());
    }

    @Test
    public void testGetAge() {
        Assertions.assertEquals("12", customer.getAge());
    }

    @Test
    public void testGetUsername() {
        Assertions.assertEquals("123321", customer.getUsername());
    }

    @Test
    public void testGetPassword() {
        Assertions.assertEquals("123321", customer.getPassword());
    }

    @Test
    public void testGetEmail() {
        Assertions.assertEquals("name@baylor.edu", customer.getEmail());
    }

    @Test
    public void testSetName() {
        testCus.setName("test");
        Assertions.assertEquals("test", testCus.getName());
    }

    @Test
    public void testSetAddress() {
        testCus.setAddress("321 Baylor Street");
        Assertions.assertEquals("321 Baylor Street", testCus.getAddress());
    }

    @Test
    public void testSetAge() {
        testCus.setAge("21");
        Assertions.assertEquals("21", testCus.getAge());
    }

    @Test
    public void testSetUsername() {
        testCus.setUsername("321123");
        Assertions.assertEquals("321123", testCus.getUsername());
    }

    @Test
    public void testSetPassword() {
        testCus.setPassword("321123");
        Assertions.assertEquals("321123", testCus.getPassword());
    }

    @Test
    public void testSetEmail() {
        testCus.setEmail("test@baylor.edu");
        Assertions.assertEquals("test@baylor.edu", testCus.getEmail());
    }
}
