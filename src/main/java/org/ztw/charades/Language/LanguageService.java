package org.ztw.charades.Language;

import org.springframework.stereotype.Service;
import org.ztw.charades.Exceptions.LanguageExistsEx;
import org.ztw.charades.Exceptions.LanguageNotFoundEx;
import org.ztw.charades.Exceptions.UserNotFoundEx;

import java.util.Collection;

@Service
public class LanguageService implements ILanguageService {
    private final ILanguageRepository langRepo;

    public LanguageService(ILanguageRepository langRepo) {
        this.langRepo = langRepo;
    }

    @Override
    public Language addLanguage(Language language) throws LanguageExistsEx {
        Long _id = language.getId();
        if (langRepo.findById(_id).isPresent()) {
            throw new LanguageExistsEx(_id);
        }
        langRepo.save(language);
        return langRepo.findById(_id).orElseThrow(
                () -> new LanguageNotFoundEx(_id)
        );
    }

    @Override
    public Collection<Language> getLanguages() {
        return langRepo.findAll();
    }

    @Override
    public Language getLanguage(Long id) throws LanguageNotFoundEx {
        return langRepo.findById(id).orElseThrow(
                () -> new LanguageNotFoundEx(id)
        );
    }

    @Override
    public Language updateLanguage(Long id, Language language) throws LanguageNotFoundEx {
        Language old_lang = langRepo.findById(id).orElseThrow(
                () -> new UserNotFoundEx(id)
        );
        old_lang.setName(language.getName());
//        old_lang.setPrompts(language.getPrompts());
        return old_lang;
    }

    @Override
    public Boolean deleteLanguage(Long id) throws LanguageNotFoundEx {
        if (langRepo.findById(id).isEmpty()) {
            throw new LanguageNotFoundEx(id);
        }
        langRepo.deleteById(id);
        return langRepo.findById(id).isEmpty();
    }
}
