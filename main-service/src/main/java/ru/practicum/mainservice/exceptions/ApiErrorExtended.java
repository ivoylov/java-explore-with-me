package ru.practicum.mainservice.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApiErrorExtended extends ApiError {
    private final List<String> errors;

    public ApiErrorExtended(String status, String reason, String message, List<String> errors) {
        super(status, reason, message);
        this.errors = errors;
    }
}
