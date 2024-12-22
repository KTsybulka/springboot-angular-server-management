package com.example.server.service.implementation;

import com.example.server.model.Server;
import com.example.server.repository.ServerRepo;
import com.example.server.service.ServerService;

import java.util.Collection;
import java.util.List;

public class ServerServiceImpl implements ServerService {
    private final ServerRepo serverRepo;

    public ServerServiceImpl(ServerRepo serverRepo) {
        this.serverRepo = serverRepo;
    }

    @Override
    public Server create(Server server) {
        return null;
    }

    @Override
    public Server pingServer(Server server) {
        return null;
    }

    @Override
    public Collection<Server> getAllSercers(int limit) {
        return List.of();
    }

    @Override
    public Server getServerById(Long id) {
        return null;
    }

    @Override
    public Server updateServer(Server server) {
        return null;
    }

    @Override
    public Boolean deleteServer(Long id) {
        return null;
    }
}
