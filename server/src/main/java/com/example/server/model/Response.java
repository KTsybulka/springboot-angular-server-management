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
}