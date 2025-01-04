package com.example.server.resource;

import com.example.server.enumeration.Status;
import com.example.server.model.Response;
import com.example.server.model.Server;
import com.example.server.service.implementation.ServerServiceImpl;
import jakarta.validation.Valid;
import lombok.Lombok;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/server")

//annotation in Lombok is used to automatically generate a constructor
@RequiredArgsConstructor
public class ServerResourse {

    private final ServerServiceImpl serverService;

    @GetMapping("/list")
    public ResponseEntity<Response> getServers() {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(Map.of("servers", serverService.getAllServers(30)))
                        .message("Success")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    @GetMapping("/ping/{ipAddress}")
    public ResponseEntity<Response> pingServer(@PathVariable("ipAddress") String ipAddress) throws IOException {
        Server server = serverService.pingServer(ipAddress);
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(Map.of("server", server))
                        .message(server.getStatus() == Status.SERVER_UP ? "Server is up" : "Server is down")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saverServer(@RequestBody @Valid Server server) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(Map.of("server", serverService.createServer(server)))
                        .message("Server created successfully")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
}