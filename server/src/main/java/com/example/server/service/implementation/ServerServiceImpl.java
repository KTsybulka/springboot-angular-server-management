package com.example.server.service.implementation;

import com.example.server.enumeration.Status;
import com.example.server.model.Server;
import com.example.server.repository.ServerRepo;
import com.example.server.service.ServerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.SplittableRandom;

import static com.example.server.enumeration.Status.SERVER_DOWN;
import static com.example.server.enumeration.Status.SERVER_UP;

//in Lombok automatically generates a constructor for all the final fields
// and any fields annotated with @NonNull in a class.
@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {
    private final ServerRepo serverRepo;


    @Override
    public Server createServer(Server server) {
        log.info("Creating server with name: {}", server.getName());
        server.setImageURL(setServerImageURL());
        return serverRepo.save(server);
    }


    @Override
    public Server pingServer(String ipAdress) throws IOException {
        log.info("Pinging server IP: {}", ipAdress);
        Server server =  serverRepo.findByIpAdress(ipAdress);
        InetAddress address = InetAddress.getByName(ipAdress);
        server.setStatus(address.isReachable(10000) ? SERVER_UP : SERVER_DOWN);
        serverRepo.save(server);
        return server;
    }

    @Override
    public Collection<Server> getAllSercers(int limit) {
        log.info("Fetching all servers");
        return serverRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Server getServerById(Long id) {
        log.info("Fetching server by id: {}", id);
        return serverRepo.findById(id).orElseThrow(() -> new RuntimeException("Server not found with id"));
    }

    @Override
    public Server updateServer(Server server) {
        log.info("Updating server with name: {}", server.getName());
        return serverRepo.save(server);
    }

    @Override
    public Boolean deleteServer(Long id) {
        log.info("Deleting server by ID: {}", id);
        serverRepo.deleteById(id);
        return true;
    }

    //URI builder using the current context path of the application.
    private String setServerImageURL() {
        String [] imageServerName = {"server1.png", "server2.png", "server3.png", "server4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/server/image/" + imageServerName[new Random().nextInt(4)]).toUriString();
    }

}
