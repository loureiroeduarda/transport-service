package com.github.loureiroeduarda.repository;

import com.github.loureiroeduarda.model.transport.Transport;

import java.util.ArrayList;
import java.util.List;

public class RepositoryTransport {
    private final List<Transport> transportList;

    public RepositoryTransport() {
        this.transportList = new ArrayList<>();
    }

    public void save(Transport transport) {
        this.transportList.add(transport);
    }
}
