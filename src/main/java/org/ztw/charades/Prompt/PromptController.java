package org.ztw.charades.Prompt;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/prompts")
@RestController
public class PromptController {
    private final IPromptService promptService;

    public PromptController(IPromptService promptService) {
        this.promptService = promptService;
    }

    @GetMapping
    public ResponseEntity<Collection<Prompt>> getPrompts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(promptService.getPrompts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prompt> getPrompt(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(promptService.getPrompt(id));
    }

    @PostMapping
    public ResponseEntity<Prompt> addPrompt(@RequestBody Prompt prompt) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(promptService.addPrompt(prompt));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prompt> updatePrompt(@PathVariable("id") Long id, @RequestBody Prompt prompt) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(promptService.updatePrompt(id, prompt));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePrompt(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(promptService.deletePrompt(id));
    }
}
