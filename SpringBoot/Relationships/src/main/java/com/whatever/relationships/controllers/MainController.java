package com.whatever.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import com.whatever.relationships.models.Category;
import com.whatever.relationships.models.Dojo;
import com.whatever.relationships.models.License;
import com.whatever.relationships.models.Ninja;
import com.whatever.relationships.models.Person;
import com.whatever.relationships.models.Product;
import com.whatever.relationships.services.CategoryProductService;
import com.whatever.relationships.services.CategoryService;
import com.whatever.relationships.services.DojoService;
import com.whatever.relationships.services.LicenseService;
import com.whatever.relationships.services.NinjaService;
import com.whatever.relationships.services.PersonService;
import com.whatever.relationships.services.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * MainController
 */
@Controller
public class MainController {

    private final PersonService personService;
    private final LicenseService licenseService;
    private final NinjaService ninjaService;
    private final DojoService dojoService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final CategoryProductService categoryProductService;

    public MainController(PersonService personService, LicenseService licenseService, NinjaService ninjaService, DojoService dojoService, ProductService productService, CategoryService categoryService, CategoryProductService categoryProductService) {
        this.personService = personService;
        this.licenseService = licenseService;
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.categoryProductService = categoryProductService;
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









    @GetMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product){
        return "newproduct.jsp";
    }

    @PostMapping("/createproduct")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result){
        if(result.hasErrors()){
            return "newproduct.jsp";
        } else {
            productService.createProduct(product);
            return "redirect:/products/new";
        }
    }

    @GetMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category){
        return "newcategory.jsp";
    }

    @PostMapping("/createcategory")
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result){
        if(result.hasErrors()){
            return "newcategory.jsp";
        } else {
            categoryService.createCategory(category);
            return "redirect:/categories/new";
        }
    }

    @GetMapping("/products/{product_id}")
    public String addCategory(@PathVariable("product_id") Long id, Model model){
        Product product = productService.findProduct(id);
        List<Category> allCategories = categoryService.allCategories();
        model.addAttribute("categories", allCategories);
        model.addAttribute("product", product);
        return "addcategory.jsp";
    }

    @PostMapping("/addcategory/{product_id}")
    public String updateCategory(@Valid @ModelAttribute("product") Product product, BindingResult result, @PathVariable("product_id") Long id){
        if(result.hasErrors()){
            return "addcategory.jsp";
        } else {
            Product oldProduct = productService.findProduct(id);
            for(int i = 0; i < product.getCategories().size(); i++){
                oldProduct.getCategories().add(product.getCategories().get(i));
            }
            productService.createProduct(oldProduct);
            return "redirect:/products/" + id;
        }
    }
}
