package com.example.server.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

// Lombok @Data generates getters, setters, toString, equals, and hashCode methods.
@Data
// Lombok @SuperBuilder supports inheritance-based builders for object creation.
@SuperBuilder
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
// Jackson will exclude null fields during JSON serialization.
@JsonInclude(NON_NULL)
// This class represents a response body for user requests to the application.
public class Response {
    protected LocalDateTime timestamp;       // When the response was created
    protected int statusCode;               // HTTP status code (e.g., 200, 404)
    protected HttpStatus status;            // Spring's representation of HTTP status
    protected String reason;                // Explanation of the status (optional)
    protected String message;               // Message for the client (e.g., success or error details)
    protected String developerMessage;      // Extra details for developers (optional)
    protected Map<?, ?> data;               // Additional data (e.g., user details, metadata)

    public Response(LocalDateTime timestamp, int statusCode, HttpStatus status, String reason, String message, String developerMessage, Map<?, ?> data) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.status = status;
        this.reason = reason;
        this.message = message;
        this.developerMessage = developerMessage;
        this.data = data;
    }

    public Response(LocalDateTime timestamp, Map<?, ?> data, String message, HttpStatus status, int statusCode) {
        this.timestamp = timestamp;
        this.data = data;
        this.message = message;
        this.status = status;
        this.statusCode = statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public Map<?, ?> getData() {
        return data;
    }

    public void setData(Map<?, ?> data) {
        this.data = data;
    }
}