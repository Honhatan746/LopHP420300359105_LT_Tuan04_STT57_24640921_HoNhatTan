package iuh.fit.se;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;

public class BankTest {

    Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank("IUH Bank", 3);
        bank.addNew("1111", "Alice", 1000.0);
        bank.addNew("2222", "Bob", 500.0);
    }
	@AfterAll
	static void tearDownAfterClass() {
		System.out.println("#End# Run after all tests");
	}

    @Test
    public void testAddNewValid() {
        bank.addNew("3333", "Charlie", 300.0);
        assertEquals(3, bank.getNumberOfAccounts());
    }

    @Test
    public void testAddNewDuplicateAccountNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            bank.addNew("1111", "Duplicate", 100.0);
        });
    }

    @Test
    public void testAddNewBankFull() {
        bank.addNew("3333", "Charlie", 300.0);
        assertThrows(IllegalArgumentException.class, () -> {
            bank.addNew("4444", "David", 200.0);
        });
    }

    @Test
    public void testFindExistingAccount() {
        BankAccount acc = bank.find("1111");
        assertNotNull(acc);
        assertEquals("Alice", acc.getOwnerName());
    }

    @Test
    public void testFindNonExistingAccount() {
        BankAccount acc = bank.find("9999");
        assertNull(acc);
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(1500.0, bank.getTotalBalance());
    }

    @Test
    public void testGetNumberOfAccounts() {
        assertEquals(2, bank.getNumberOfAccounts());
    }

    @Test
    public void testGetAccounts() {
        BankAccount[] accounts = bank.getAccounts();
        assertEquals(2, accounts.length);
        assertEquals("Alice", accounts[0].getOwnerName());
    }

    @Test
    public void testSetNameValid() {
        bank.setName("NewBank");
        assertEquals("NewBank", bank.getName());
    }

    @Test
    public void testSetNameInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            bank.setName("");
        });
    }
}