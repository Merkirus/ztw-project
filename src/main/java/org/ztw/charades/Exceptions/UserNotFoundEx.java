package org.ztw.charades.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundEx extends RuntimeException {
    public UserNotFoundEx(Long id) {
        super("id: " + id);
    }

    public UserNotFoundEx() {
        super("XD");
    }
}
