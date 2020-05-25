package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

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

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotSavePropertiesWhenIdIsNull() {
        Client sut = new Client(null, dummyName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotSavePropertiesWhenNameIsNull() {
        Client sut = new Client(stubId, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotSavePropertiesWhenNameIsEmpty() {
        Client sut = new Client(stubId, "");
    }
}
