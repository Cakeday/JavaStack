package com.whatever.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import com.whatever.relationships.models.Dojo;
import com.whatever.relationships.models.License;
import com.whatever.relationships.models.Ninja;
import com.whatever.relationships.models.Person;
import com.whatever.relationships.services.DojoService;
import com.whatever.relationships.services.LicenseService;
import com.whatever.relationships.services.NinjaService;
import com.whatever.relationships.services.PersonService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * MainController
 */
@Controller
public class MainController {

    private final PersonService personService;
    private final LicenseService licenseService;
    private final NinjaService ninjaService;
    private final DojoService dojoService;

    public MainController(PersonService personService, LicenseService licenseService, NinjaService ninjaService, DojoService dojoService) {
        this.personService = personService;
        this.licenseService = licenseService;
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }


    @GetMapping("/")
    public String index(){
        return "index.jsp";
    }

    @GetMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "newperson.jsp";
    }

    @PostMapping("/createperson")
    public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result){
        if (result.hasErrors()) {
            return "newperson.jsp";
        } else {
            personService.createPerson(person);
            return "redirect:/persons/new";
        }
    }

    @GetMapping("/licenses/new")
    public String newLicense(@ModelAttribute("license") License license, Model model){
        List<Person> allPeople = personService.getPeopleWithoutId();
        model.addAttribute("allPeople", allPeople);
        return "newlicense.jsp";
    }

    @PostMapping("createlicense")
    public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result){
        if (result.hasErrors()) {
            return "newlicense.jsp";
        } else {
            licenseService.createLicense(license);
            return "redirect:/licenses/new";
        }
    }





    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo){
        return "newdojo.jsp";
    }

    @PostMapping("/createdojo")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if(result.hasErrors()){
            return "newdojo.jsp";
        } else{
            dojoService.createDojo(dojo);
            return "redirect:/dojos/new";
        }
    }

    @GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model){
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "newninja.jsp";
    }

    @PostMapping("/createninja")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if(result.hasErrors()){
            return "newninja.jsp";
        } else{
            ninjaService.createNinja(ninja);
            return "redirect:/ninjas/new";
        }
    }

    @GetMapping("/dojos/{id}")
    public String showNinjasPerDojo(Model model, @PathVariable("id") Long id){
        Dojo dojo = dojoService.findDojo(id);
        List<Ninja> ninjas = dojo.getNinjas();
        model.addAttribute("dojo", dojo);
        model.addAttribute("ninjas", ninjas);
        return "ninjasperdojo.jsp";
    }








}