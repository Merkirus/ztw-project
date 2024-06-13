package org.ztw.charades.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class UserExistsEx extends RuntimeException {
    public UserExistsEx(Long id) {
        super("id:" + id);
    }

    public UserExistsEx() {
        super("XD");
    }
}
