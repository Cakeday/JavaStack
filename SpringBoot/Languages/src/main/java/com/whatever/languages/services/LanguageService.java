package com.whatever.languages.services;

import java.util.List;
import java.util.Optional;

import com.whatever.languages.models.Language;
import com.whatever.languages.repositories.LanguageRepository;

import org.springframework.stereotype.Service;

/**
 * LanguageService
 */
@Service
public class LanguageService {

    private final LanguageRepository languageRepository;
// The below constructor must match the classname!!!
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    // returns all the languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }

    // creates a language
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }

    // retrieves a language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
    public Language updateLanguagecopy(long id, String name, String creator, String currentVersion) {
    	Language language = findLanguage(id);
    	language.setName(name);
    	language.setCreator(creator);
    	language.setCurrentVersion(currentVersion);
    	Language lang = languageRepository.save(language);
    	return lang;
    }
    
    public void deleteLanguage(long id) {
    	languageRepository.deleteById(id);
    }
}