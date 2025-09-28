package iuh.fit.se;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;

public class BankAccountTest {

    BankAccount acc1;
    BankAccount acc2;

    @BeforeEach
    public void setUp() {
        acc1 = new BankAccount("1234-5678-9012", "Alice", 1000.0);
        acc2 = new BankAccount("9876-5432-1098", "Bob", 500.0);
    }
	@AfterAll
	static void tearDownAfterClass() {
		System.out.println("#End# Run after all tests");
	}
    @Test
    public void testDepositValid() {
        acc1.deposit(200.0);
        assertEquals(1200.0, acc1.getBalance());
    }

    @Test
    public void testDepositInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            acc1.deposit(-100.0);
        });
    }

    @Test
    public void testWithdrawValid() {
        acc1.withdraw(300.0);
        assertEquals(700.0, acc1.getBalance());
    }

    @Test
    public void testWithdrawInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            acc1.withdraw(2000.0);
        });
    }

    @Test
    public void testTransferValid() {
        acc1.transfer(acc2, 400.0);
        assertEquals(600.0, acc1.getBalance());
        assertEquals(900.0, acc2.getBalance());
    }

    @Test
    public void testTransferInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            acc1.transfer(acc2, 2000.0);
        });
    }

    @Test
    public void testSetAccountNumberInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            acc1.setAccountNumber("");
        });
    }

    @Test
    public void testSetOwnerNameInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            acc1.setOwnerName(null);
        });
    }

}