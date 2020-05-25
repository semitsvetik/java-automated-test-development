package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ClientTest {
    private UUID stubId;
    private String dummyName;

    @Before
    public void prepareTestData() {
        stubId = UUID.randomUUID();
        dummyName = "dummy client name";
        System.out.println("Executed before each test");
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldSavePropertiesWhenCreated() {
        Client sut = new Client(stubId, dummyName);

        assertThat(sut.getId(),
                allOf(
                        equalTo(stubId),
                        notNullValue()
                ));
        assertThat(sut.getName(),
                allOf(
                        equalTo(dummyName),
                        notNullValue()
                ));
    }

    @Test
    public void shouldThrowExceptionWhenIdIsNull() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Pre-requisite failed: Client id is null");
        Client sut = new Client(null, dummyName);
    }

    @Test
    public void shouldThrowExceptionWhenNameIsNull() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Pre-requisite failed: Client name is null");
        Client sut = new Client(stubId, null);
    }

    @Test
    public void shouldThrowExceptionWhenNameIsEmpty() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Pre-requisite failed: Client name is empty");
        Client sut = new Client(stubId, "");
    }
}
