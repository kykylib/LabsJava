package liberman.lab5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTerminal {
    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void testCreateAccount() {
        bank.createAccount("1", 10);
        assertEquals(1, bank.getBankAccountList().size());
    }

    @Test
    public void testFindAccount() {
        bank.createAccount("2", 10);
        BankAccount account = bank.findAccount(2);
        assertEquals(2, account.getAccountNumber());
    }
    @Test
    public void testTransferMoney() {
        bank.createAccount("3", 10);
        bank.createAccount("4", 0);
        bank.transferMoney(3,4,10);
        assertEquals(10, bank.getBankAccountList().get(1).getBalance());
    }
}
