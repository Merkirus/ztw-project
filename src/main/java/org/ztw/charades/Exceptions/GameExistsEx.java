package org.ztw.charades.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class GameExistsEx extends RuntimeException {
    public GameExistsEx(Long id) {
        super("id: " + id);
    }

    public GameExistsEx() {
        super("XD");
    }
}
