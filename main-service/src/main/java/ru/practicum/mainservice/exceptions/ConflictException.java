package ru.practicum.mainservice.exceptions;

public class ConflictException extends RuntimeException {

    private final String reason;

    public ConflictException(String message, String reason) {
        super(message);
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
