package io.cloudsoft.lightningtalk.httpclientapi.persistence;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer code) {
        super("User with code " + code + " not found");
    }
}
