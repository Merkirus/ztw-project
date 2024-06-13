package org.ztw.charades.Prompt;

import org.ztw.charades.Exceptions.PromptExistsEx;
import org.ztw.charades.Exceptions.PromptNotFoundEx;

import java.util.Collection;

public interface IPromptService {
    abstract public Prompt addPrompt(Prompt prompt) throws PromptExistsEx;
    abstract public Collection<Prompt> getPrompts();
    abstract public Prompt getPrompt(Long id) throws PromptNotFoundEx;
    abstract public Prompt updatePrompt(Long id, Prompt prompt) throws PromptNotFoundEx;
    abstract public Boolean deletePrompt(Long id) throws PromptNotFoundEx;
}
