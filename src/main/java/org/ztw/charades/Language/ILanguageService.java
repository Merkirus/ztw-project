package org.ztw.charades.Language;

import org.springframework.transaction.annotation.Transactional;
import org.ztw.charades.Exceptions.LanguageExistsEx;
import org.ztw.charades.Exceptions.LanguageNotFoundEx;

import java.util.Collection;

public interface ILanguageService {
    @Transactional
    abstract public Language addLanguage(Language language) throws LanguageExistsEx;
    abstract public Collection<Language> getLanguages();
    abstract public Language getLanguage(Long id) throws LanguageNotFoundEx;
    @Transactional
    abstract public Language updateLanguage(Long id, Language language) throws LanguageNotFoundEx;
    @Transactional
    abstract public Boolean deleteLanguage(Long id) throws LanguageNotFoundEx;
}
