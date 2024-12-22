package com.example.server.service;

import com.example.server.model.Server;

import java.util.Collection;
import java.util.List;

public interface ServerService {
    Server create(Server server);
    Server pingServer(Server server);
    Collection<Server> getAllSercers(int limit);
    Server getServerById(Long id);
    Server updateServer(Server server);
    Boolean deleteServer(Long id);
}
