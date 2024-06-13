package org.ztw.charades.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class PlayerExistsEx extends RuntimeException {
    public PlayerExistsEx(Long id) {
        super("id: " + id);
    }

    public PlayerExistsEx() {
        super("XD");
    }
}
