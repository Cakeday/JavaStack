package com.whatever.routing.routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DojoController
 */
@RestController
public class DojoController {

    @RequestMapping("/{var}")
    public String display(@PathVariable("var") String var){
        if(var.equals("dojo")){
            return "The dojo is awesome!";
        }
        else if (var.equals("san-jose")){
            return "SJ dojo is the headquarters";
        } 
        else if(var.equals("burbank-dojo")){
            return "Burbank Dojo is located in southern california.";
        }
        return "Ayooooooooooo";
    }
}