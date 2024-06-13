package org.ztw.charades.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RoundNotFoundEx extends RuntimeException {
    public RoundNotFoundEx(Long id) {
        super("id: " + id);
    }

    public RoundNotFoundEx() {
        super("XD");
    }
}
