package ru.practicum.mainservice.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApiErrors extends ApiError {

    private final List<String> errors;

    public ApiErrors(String status, String reason, String message, List<String> errors) {
        super(status, reason, message);
        this.errors = errors;
    }

}
