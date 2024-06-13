package org.ztw.charades.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlayerNotFoundEx extends RuntimeException {
    public PlayerNotFoundEx(Long id) {
        super("id: " + id);
    }

    public PlayerNotFoundEx() {
        super("XD");
    }
}
