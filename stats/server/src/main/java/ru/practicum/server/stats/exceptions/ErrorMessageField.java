package ru.practicum.server.stats.exceptions;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorMessageField {

    final String field;
    final String message;

    public ErrorMessageField(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getErrorMessage() {
        return "Field: " + field + ". Error: " + message + ". ";
    }

}
