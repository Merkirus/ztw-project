package org.ztw.charades.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LanguageNotFoundEx extends RuntimeException {
    public LanguageNotFoundEx(Long id) {
        super("id: " + id);
    }

    public LanguageNotFoundEx() {
        super("XD");
    }
}
