package org.ztw.charades.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class PromptExistsEx extends RuntimeException {
    public PromptExistsEx(Long id) {
        super("id: " + id);
    }

    public PromptExistsEx() {
        super("XD");
    }
}
