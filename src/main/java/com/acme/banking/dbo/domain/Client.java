package com.acme.banking.dbo.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Client {
    private UUID id;
    private String name;
    private Collection<UUID> accountIds = new ArrayList<>();

    public Client(UUID id, String name) {
        if (id == null)
            throw new IllegalArgumentException("Pre-requisite failed: Client id is null");
        if (name == null)
            throw new IllegalArgumentException("Pre-requisite failed: Client name is null");
        else if (name.isEmpty()) {
            throw new IllegalArgumentException("Pre-requisite failed: Client name is empty");
        }

        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
