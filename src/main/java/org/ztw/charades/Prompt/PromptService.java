package org.ztw.charades.Prompt;

import org.springframework.stereotype.Service;
import org.ztw.charades.Exceptions.PromptExistsEx;
import org.ztw.charades.Exceptions.PromptNotFoundEx;

import java.util.Collection;

@Service
public class PromptService implements IPromptService {
    private final IPromptRepository promptRepo;

    public PromptService(IPromptRepository promptRepo) {
        this.promptRepo = promptRepo;
    }

    @Override
    public Prompt addPrompt(Prompt prompt) throws PromptExistsEx {
        Long _id = prompt.getId();
        if (promptRepo.findById(_id).isPresent()) {
            throw new PromptExistsEx(_id);
        }
        promptRepo.save(prompt);
        return promptRepo.findById(_id).orElseThrow(
                () -> new PromptNotFoundEx(_id)
        );
    }

    @Override
    public Collection<Prompt> getPrompts() {
        return promptRepo.findAll();
    }

    @Override
    public Prompt getPrompt(Long id) throws PromptNotFoundEx {
        return promptRepo.findById(id).orElseThrow(
                () -> new PromptNotFoundEx(id)
        );
    }

    @Override
    public Prompt updatePrompt(Long id, Prompt prompt) throws PromptNotFoundEx {
        Prompt old_prompt = promptRepo.findById(id).orElseThrow(
                () -> new PromptNotFoundEx(id)
        );
        old_prompt.setName(prompt.getName());
        old_prompt.setLanguage(prompt.getLanguage());
        return old_prompt;
    }

    @Override
    public Boolean deletePrompt(Long id) throws PromptNotFoundEx {
        if (promptRepo.findById(id).isEmpty()) {
            throw new PromptNotFoundEx(id);
        }
        promptRepo.deleteById(id);
        return promptRepo.findById(id).isEmpty();
    }
}
