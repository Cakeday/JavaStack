package com.whatever.languages.repositories;

import java.util.List;

import com.whatever.languages.models.Language;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * LanguageRepository
 */
@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
    List<Language> findAll();
    // this method finds languages with descriptions containing the search string

}