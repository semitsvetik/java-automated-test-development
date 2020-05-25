package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;
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

    @After
    public void postTestRun() {
        System.out.println("Executed after each test");
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Rule
    public final TestName name = new TestName();

    @Category(PositiveTests.class)
    @Test
    public void shouldSavePropertiesWhenCreated() {
        System.out.println("Test is executing: " + name.getMethodName());
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

    @Category(NegativeTests.class)
    @Test
    public void shouldThrowExceptionWhenIdIsNull() {
        System.out.println("Test is executing: " + name.getMethodName());
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Pre-requisite failed: Client id is null");
        Client sut = new Client(null, dummyName);
    }

    @Category(NegativeTests.class)
    @Test
    public void shouldThrowExceptionWhenNameIsNull() {
        System.out.println("Test is executing: " + name.getMethodName());
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Pre-requisite failed: Client name is null");
        Client sut = new Client(stubId, null);
    }

    @Category(NegativeTests.class)
    @Test
    public void shouldThrowExceptionWhenNameIsEmpty() {
        System.out.println("Test is executing: " + name.getMethodName());
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Pre-requisite failed: Client name is empty");
        Client sut = new Client(stubId, "");
    }
}
