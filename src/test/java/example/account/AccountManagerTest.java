package example.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AccountManagerTest {
    private AccountManager accountManager;
    private Customer customer;

    @BeforeEach
    void setUp() {
        accountManager = new AccountManagerImpl();
        customer = new Customer();
    }

    @Nested
    class WithdrawTests {
        @Test
        void givenCustomerWithSufficientBalance_whenWithdraw_thenSucceed() {
            // Arrange
            customer.setBalance(1000);

            // Act
            String result = accountManager.withdraw(customer, 500);

            // Assert
            assertThat(result).isEqualTo("success");
            assertThat(customer.getBalance()).isEqualTo(500);
        }

        @Test
        void givenCustomerWithInsufficientBalanceAndNoCreditAllowed_whenWithdraw_thenFail() {
            // Arrange
            customer.setBalance(300);
            customer.setCreditAllowed(false);

            // Act
            String result = accountManager.withdraw(customer, 500);

            // Assert
            assertThat(result).isEqualTo("insufficient account balance");
            assertThat(customer.getBalance()).isEqualTo(300);
        }
    }
}
