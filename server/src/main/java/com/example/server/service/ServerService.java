package com.example.server.service;

import com.example.server.model.Server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.List;

public interface ServerService {
    Server createServer(Server server);
    Server pingServer(String ipAdress) throws IOException;
    Collection<Server> getAllServers(int limit);
    Server getServerById(Long id);
    Server updateServer(Server server);
    Boolean deleteServer(Long id);
}
