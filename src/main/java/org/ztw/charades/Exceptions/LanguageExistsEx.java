package org.ztw.charades.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class LanguageExistsEx extends RuntimeException {
    public LanguageExistsEx(Long id) {
        super("id: " + id);
    }

    public LanguageExistsEx() {
        super("XD");
    }
}
