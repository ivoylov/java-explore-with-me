package ru.practicum.mainservice.exceptions;

import lombok.Getter;

@Getter
public class ErrorFieldMessage {

    private final String field;
    private final String message;

    public ErrorFieldMessage(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getErrorMessage() {
        return String.format("Field: %s. Error: %s.", field, message);
    }

}
