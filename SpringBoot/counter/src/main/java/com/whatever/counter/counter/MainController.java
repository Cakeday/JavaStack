package com.whatever.counter.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MainController
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index(HttpSession session){
        if (session.getAttribute("count") == null){
            session.setAttribute("count", 0);
        }
        System.out.println("whee caleb");
        Integer count = (Integer) session.getAttribute("count");
        count += 1;
        session.setAttribute("count", count);
        return "index.jsp";
    }
    
    @RequestMapping("/counter")
    public String counter(Model model, HttpSession session){
        System.out.println("counter");
        Integer count = (Integer) session.getAttribute("count");
        model.addAttribute("count", count);
        return "counter.jsp";
    }
    

    
}