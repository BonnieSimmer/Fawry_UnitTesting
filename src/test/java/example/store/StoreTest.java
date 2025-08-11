package example.store;

import example.account.AccountManager;
import example.account.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StoreTest {
    private AccountManager accountManager;
    private Store store;
    private Product product;
    private Customer customer;

    @BeforeEach
    void setUp() {
        accountManager = mock(AccountManager.class);
        store = new StoreImpl(accountManager);
        product = new Product();
        customer = new Customer();
    }

    @Test
    void givenEnoughQuantityAndSuccessfulWithdraw_WhenBuy_ThenQuantityDecrease() {
        // Arrange
        when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        product.setQuantity(4);

        // Act
        store.buy(product, customer);

        // Assert
        assertThat(product.getQuantity()).isEqualTo(3);
        verify(accountManager, times(1)).withdraw(customer, product.getPrice());
    }

}
