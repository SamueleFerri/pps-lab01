import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private double amount;
    private int notExistingAccountHolderId;
    private static final int WITHDRAWALFEE = 1;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, 0);
        amount = 100;
        notExistingAccountHolderId = 2;
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.id(), amount);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.id(), amount);
        bankAccount.deposit(notExistingAccountHolderId, amount);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.id(), amount);
        amount = 70;
        bankAccount.withdraw(accountHolder.id(), amount);
        assertEquals(30 - WITHDRAWALFEE, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.id(), amount);
        bankAccount.withdraw(notExistingAccountHolderId, amount);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testNegativeBalanceAfterWithDraw(){
        bankAccount.deposit(accountHolder.id(), amount);
        bankAccount.withdraw(accountHolder.id(), amount);
        assertEquals(100, bankAccount.getBalance());
    }
}
