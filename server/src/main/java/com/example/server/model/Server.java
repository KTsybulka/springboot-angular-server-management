package com.example.server.model;

import com.example.server.enumeration.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.SplittableRandom;

import static jakarta.persistence.GenerationType.AUTO;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class Server {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "Please enter an IP address")
    private String ipAddress;
    private String name;
    private String memory;
    private String type;
    private String imageURL;
    private Status status;

    public Server(Long id, String ipAddress, String name, String memory, String type, String imageURL, Status status) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.name = name;
        this.memory = memory;
        this.type = type;
        this.imageURL = imageURL;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public @NotEmpty(message = "Please enter an IP address") String getIpAddress() {
        return ipAddress;
    }

    public String getName() {
        return name;
    }

    public String getMemory() {
        return memory;
    }

    public String getType() {
        return type;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIpAddress(@NotEmpty(message = "Please enter an IP address") String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
