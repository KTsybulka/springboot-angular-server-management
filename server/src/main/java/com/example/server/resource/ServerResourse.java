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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/server")

//annotation in Lombok is used to automatically generate a constructor
//@RequiredArgsConstructor
public class ServerResourse {


    private final ServerServiceImpl serverService;

    public ServerResourse(ServerServiceImpl serverService) {
        this.serverService = serverService;
    }

    @GetMapping("/list")
    public ResponseEntity<Response> getServers() {
        return ResponseEntity.ok(
                new Response(now(), Map.of("servers", serverService.getAllServers(30)),
                        "Success", OK, OK.value()));

//                Response.builder()
//                        .timestamp(now())
//                        .data(Map.of("servers", serverService.getAllServers(30)))
//                        .message("Success")
//                        .status(OK)
//                        .statusCode(OK.value())
//                        .build());
    }

    @GetMapping("/ping/{ipAddress}")
    public ResponseEntity<Response> pingServer(@PathVariable("ipAddress") String ipAddress) throws IOException {
        Server server = serverService.pingServer(ipAddress);
        return ResponseEntity.ok(
                new Response(now(), Map.of("server", server),
                        server.getStatus() == Status.SERVER_UP ? "Server is up" : "Server is down", OK, OK.value()));

//                Response.builder()
//                        .timestamp(now())
//                        .data(Map.of("server", server))
//                        .message(server.getStatus() == Status.SERVER_UP ? "Server is up" : "Server is down")
//                        .status(OK)
//                        .statusCode(OK.value())
//                        .build());
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saverServer(@RequestBody @Valid Server server) {
        return ResponseEntity.ok(
                new Response(now(), Map.of("server", serverService.createServer(server)),
                        "Server created successfully", CREATED, CREATED.value()));
//                Response.builder()
//                        .timestamp(now())
//                        .data(Map.of("server", serverService.createServer(server)))
//                        .message("Server created successfully")
//                        .status(CREATED)
//                        .statusCode(CREATED.value())
//                        .build());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getServerById(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                new Response(now(), Map.of("server", serverService.getServerById(id)),
                        "Server fetched successfully", OK, OK.value()));

//                Response.builder()
//                        .timestamp((now()))
//                        .data(Map.of("server", serverService.getServerById(id)))
//                        .message("Server fetched successfully")
//                        .status(OK)
//                        .statusCode(OK.value())
//                        .build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteServer(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                new Response(now(), Map.of("deleted", serverService.deleteServer(id)),
                        "Server deleted successfully", OK, OK.value()));
//                Response.builder()
//                        .timestamp(now())
//                        .data(Map.of("deleteed", serverService.deleteServer(id)))
//                        .message("Server deleted successfully")
//                        .status(OK)
//                        .statusCode(OK.value())
//                        .build());
    }

    @GetMapping(path = "/image/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getServerImage(@PathVariable("fileNmae") String filname) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "Downloads/images" + filname));
    }

}