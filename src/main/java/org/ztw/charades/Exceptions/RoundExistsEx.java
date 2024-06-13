package org.ztw.charades.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class RoundExistsEx extends RuntimeException {
    public RoundExistsEx(Long id) {
        super("id: " + id);
    }

    public RoundExistsEx() {
        super("XD");
    }
}
