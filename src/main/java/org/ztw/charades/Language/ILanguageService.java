package org.ztw.charades.Language;

import org.ztw.charades.Exceptions.LanguageExistsEx;
import org.ztw.charades.Exceptions.LanguageNotFoundEx;

import java.util.Collection;

public interface ILanguageService {
    abstract public Language addLanguage(Language language) throws LanguageExistsEx;
    abstract public Collection<Language> getLanguages();
    abstract public Language getLanguage(Long id) throws LanguageNotFoundEx;
    abstract public Language updateLanguage(Long id, Language language) throws LanguageNotFoundEx;
    abstract public Boolean deleteLanguage(Long id) throws LanguageNotFoundEx;
}
