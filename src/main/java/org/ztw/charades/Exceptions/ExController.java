package org.ztw.charades.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExController {

    @ResponseBody
    @ExceptionHandler(UserNotFoundEx.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    ResponseEntity<?> UNFEHandler(UserNotFoundEx e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header(HttpHeaders.CONTENT_TYPE)
                .body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(UserExistsEx.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    ResponseEntity<?> UEEHandler(UserExistsEx e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .header(HttpHeaders.CONTENT_TYPE)
                .body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(RoundNotFoundEx.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    ResponseEntity<?> RNFEHandler(RoundNotFoundEx e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header(HttpHeaders.CONTENT_TYPE)
                .body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(RoundExistsEx.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    ResponseEntity<?> REEHandler(RoundExistsEx e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .header(HttpHeaders.CONTENT_TYPE)
                .body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(PromptNotFoundEx.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    ResponseEntity<?> PrNFEHandler(PromptNotFoundEx e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header(HttpHeaders.CONTENT_TYPE)
                .body(e.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(PromptExistsEx.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    ResponseEntity<?> PrEEHandler(PromptExistsEx e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .header(HttpHeaders.CONTENT_TYPE)
                .body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(PlayerNotFoundEx.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    ResponseEntity<?> PlNFEHandler(PlayerNotFoundEx e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header(HttpHeaders.CONTENT_TYPE)
                .body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(PlayerExistsEx.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    ResponseEntity<?> PlEEHandler(PlayerExistsEx e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .header(HttpHeaders.CONTENT_TYPE)
                .body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(LanguageNotFoundEx.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    ResponseEntity<?> LNFEHandler(LanguageNotFoundEx e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header(HttpHeaders.CONTENT_TYPE)
                .body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(LanguageExistsEx.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    ResponseEntity<?> LEEHandler(LanguageExistsEx e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .header(HttpHeaders.CONTENT_TYPE)
                .body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(GameNotFoundEx.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    ResponseEntity<?> GNFEHandler(GameNotFoundEx e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header(HttpHeaders.CONTENT_TYPE)
                .body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(GameExistsEx.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    ResponseEntity<?> GEEHandler(GameExistsEx e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .header(HttpHeaders.CONTENT_TYPE)
                .body(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(BadRequestEx.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    ResponseEntity<?> BREHandler(BadRequestEx e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .header(HttpHeaders.CONTENT_TYPE)
                .body(e.getMessage());
    }
}
