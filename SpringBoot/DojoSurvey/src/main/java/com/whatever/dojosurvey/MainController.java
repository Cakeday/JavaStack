package com.whatever.dojosurvey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * MainController
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping("/result")
    public String showInfo(Model model, HttpSession session){
        model.addAttribute("name",(String) session.getAttribute("name") );
        model.addAttribute("location",(String) session.getAttribute("location") );
        model.addAttribute("language",(String) session.getAttribute("language") );
        model.addAttribute("comment",(String) session.getAttribute("comment") );
        return "info.jsp";
    }

    @RequestMapping(value = "/submitted", method = RequestMethod.POST)
    public String postInfo(
        HttpSession session,
        @RequestParam("name") String name, 
        @RequestParam("location") String location, 
        @RequestParam("language") String language, 
        @RequestParam("comment") String comment, 
        Model model
                            ){
        session.setAttribute("name", name);
        session.setAttribute("location", location);
        session.setAttribute("language", language);
        session.setAttribute("comment", comment);
        return "redirect:/result";
    }
    
}