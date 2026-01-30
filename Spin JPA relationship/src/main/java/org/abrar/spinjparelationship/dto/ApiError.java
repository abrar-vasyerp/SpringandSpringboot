package org.abrar.spinjparelationship.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private boolean success;
    private String message;
    private LocalDateTime timestamp;
}
