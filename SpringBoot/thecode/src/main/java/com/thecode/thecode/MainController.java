package com.thecode.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * MainController
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping(value = "/code", method = RequestMethod.POST)
    public String code(@RequestParam(value="code") String code, RedirectAttributes redirectAttributes){
        if(code.equals("bushido")){
            return "code.jsp";
        }
        redirectAttributes.addFlashAttribute("error", "You must train harder!");
        return "redirect:/";
    }
}