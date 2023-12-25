package ru.practicum.mainservice.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError {

    private final String status;
    private final String reason;
    private final String message;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime timestamp = LocalDateTime.now();

    public ApiError(String status, String reason, String message) {
        this.status = status;
        this.reason = reason;
        this.message = message;
    }

}
