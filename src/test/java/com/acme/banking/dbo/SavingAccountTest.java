package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

interface PositiveTests { /* category marker */ }
interface NegativeTests { /* category marker */ }

public class SavingAccountTest {
    UUID dummyUuid;
    Client dummyClient;

    @Before
    public void prepareTestData() {
        dummyUuid = UUID.randomUUID();
        dummyClient = new Client(dummyUuid, "name");
    }

    @Category(PositiveTests.class)
    @Test
    public void shouldCreateAccountWhenNotNullIdAndClient() {
        SavingAccount sut = new SavingAccount(dummyUuid, dummyClient, 0);

        assertThat(sut.getId(),
                allOf(
                        equalTo(dummyUuid)
                ));

        assertThat(sut.getClient(),
                allOf(
                        equalTo(dummyClient)
                ));
    }

    @Category(PositiveTests.class)
    @Test
    public void shouldSaveAmountWhenCreated() {
        dummyUuid = UUID.randomUUID();
        dummyClient = new Client(dummyUuid, "name");
        double amount = 35000;

        SavingAccount sut = new SavingAccount(dummyUuid, dummyClient, amount);
        assertThat(sut.getAmount(),
                allOf(
                        equalTo(amount)
                ));
    }

    @Category(NegativeTests.class)
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateAccountWhenNullId() {
        dummyUuid = UUID.randomUUID();
        dummyClient = new Client(dummyUuid, "name");

        new SavingAccount(null, dummyClient, 0);
    }

    @Category(NegativeTests.class)
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateAccountWhenNullClient() {
        dummyUuid = UUID.randomUUID();
        dummyClient = new Client(dummyUuid, "name");

        new SavingAccount(dummyUuid, null, 0);
    }
}
