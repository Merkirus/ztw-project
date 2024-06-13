package org.ztw.charades.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PromptNotFoundEx extends RuntimeException {
    public PromptNotFoundEx(Long id) {
        super("id: " + id);
    }

    public PromptNotFoundEx() {
        super("XD");
    }
}
