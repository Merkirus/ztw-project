package org.ztw.charades.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class GameNotFoundEx extends RuntimeException {
    public GameNotFoundEx(Long id) {
        super("id: " + id);
    }

    public GameNotFoundEx() {
        super("XD");
    }
}
