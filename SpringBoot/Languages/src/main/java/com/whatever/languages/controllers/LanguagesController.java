package com.whatever.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import com.whatever.languages.models.Language;
import com.whatever.languages.services.LanguageService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;






/**
 * LanguageController
 */

 @Controller
public class LanguagesController {

    private final LanguageService languageService;

    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping(value="/languages")
    public String index(Model model, @ModelAttribute("language") Language language) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "/index.jsp";
    }

    @PostMapping(value="/languages")
    public String postMethodName(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/index.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }

    @GetMapping(value="/languages/{id}")
    public String show(@PathVariable Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "show.jsp";
    }
    
    @GetMapping(value="/languages/{id}/edit")
    public String edit(@PathVariable(value = "id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }
    
    @PostMapping(value="/languages/{id}")
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/edit.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }

    @GetMapping(value = "/languages/{id}/delete")
    public String delete(@PathVariable(value = "id") Long id){
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
    
    
    
    
}