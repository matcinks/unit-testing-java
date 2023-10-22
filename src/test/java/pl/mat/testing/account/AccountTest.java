package pl.mat.testing.account;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@Tag("fries")
class AccountTest {

    @Test
    void newAccountShouldNotBeActiveAfterCreation() {

        //given
        //when
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive(), "Check if new account is not active");
//        assertThat(newAccount.isActive()).isFalse(); // <- asercja z junit
        assertThat(newAccount.isActive(), equalTo(false));
        assertThat(newAccount.isActive(), is(false));

    }

    @Test
    void accountShouldBeActiveAfterActivation() {

        //given
        Account newAccount = new Account();

        //when
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive());
        assertThat(newAccount.isActive(), equalTo(true));
//        assertThat(newAccount.isActive()).isTrue();

    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {

        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDeliveryAddress();

        //then
        assertNull(address);
        assertThat(address, nullValue());
//        assertThat(address).isNull();

    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {

        //given
        Address address = new Address("Krakowska", "67C");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);

        //when
        Address defaultAddress = account.getDefaultDeliveryAddress();

        //then
        assertNotNull(defaultAddress);
//        assertThat(defaultAddress).isNotNull();
        assertThat(defaultAddress, is(notNullValue()));

    }

    @RepeatedTest(5)
    @Test
    void newAccountWithNotNullAddressShouldBeActive() {

        //given
        Address address = new Address("Puławska", "46/6");

        //when
        Account account = new Account(address);

        //then
        assumingThat(address != null, () -> {
            assertTrue(account.isActive());
        });

    }

    @Test
    void invalidEmailShouldThrowException() {

        //given
        Account account = new Account();

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> account.setEmail("wrongEmail"));

    }

    @Test
    void validEmailShouldBeSet() {

        //given
        Account account = new Account();

        //when
        account.setEmail("kontakt@mat-ste.com");

        //then
        assertThat(account.getEmail(), is("kontakt@mat-ste.com"));

    }

}
