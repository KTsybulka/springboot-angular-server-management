package com.example.server.enumeration;

public enum Status {
    SERVER_UP("Server is up"),
    SERVER_DOWN("Server is down");

    private String status;

    Status (String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
