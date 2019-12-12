package com.whatever.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import com.whatever.relationships.models.License;
import com.whatever.relationships.models.Person;
import com.whatever.relationships.services.LicenseService;
import com.whatever.relationships.services.PersonService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * MainController
 */
@Controller
public class MainController {

    private final PersonService personService;
    private final LicenseService licenseService;

    public MainController(PersonService personService, LicenseService licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }


    @GetMapping(value="/")
    public String index(){
        return "index.jsp";
    }

    @GetMapping(value="/persons/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "newperson.jsp";
    }

    @PostMapping(value="/createperson")
    public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result){
        if (result.hasErrors()) {
            return "/newperson.jsp";
        } else {
            personService.createPerson(person);
            return "redirect:/persons/new";
        }
    }

    @GetMapping(value="/licenses/new")
    public String newLicense(@ModelAttribute("license") License license, Model model){
        List<Person> allPeople = personService.getPeopleWithoutId();
        model.addAttribute("allPeople", allPeople);
        return "newlicense.jsp";
    }

    @PostMapping(value="createlicense")
    public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result){
        if (result.hasErrors()) {
            return "/newlicense.jsp";
        } else {
            licenseService.createLicense(license);
            return "redirect:/licenses/new";
        }
    }
}