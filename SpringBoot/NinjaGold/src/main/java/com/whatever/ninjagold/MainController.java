package com.whatever.ninjagold;

// import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * MainController
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index(HttpSession session, Model model){
        System.out.println(session.getAttribute("amount"));
        System.out.println(session.getAttribute("justEarned"));

        model.addAttribute("justEarned", session.getAttribute("justEarned"));
        return "index.jsp";
    }

    @PostMapping("/getgold")
    public String gold(@RequestParam(value="place") String place, HttpSession session) {
        Random ran = new Random();
        if (session.getAttribute("amount")==null){
            session.setAttribute("amount", 0);
        }
        if (session.getAttribute("justEarned")==null){
            session.setAttribute("justEarned", 0);
        }
        else{
            if(place.equals("farm")){
                int current = (int) session.getAttribute("amount");
                int gold = ran.nextInt(20-10)+10;
                session.setAttribute("amount", gold+current);
                session.setAttribute("justEarned", gold);
            }
            if(place.equals("cave")){
                int current = (int) session.getAttribute("amount");
                int gold = ran.nextInt(10-5)+5;
                session.setAttribute("amount", gold+current);
                session.setAttribute("justEarned", gold);
            }
            if(place.equals("house")){
                int current = (int) session.getAttribute("amount");
                int gold = ran.nextInt(5-2)+2;
                session.setAttribute("amount", gold+current);
                session.setAttribute("justEarned", gold);
            }
            if(place.equals("casino")){
                int current = (int) session.getAttribute("amount");
                int gold = ran.nextInt(50-(-50))+(-50);
                session.setAttribute("amount", gold+current);
                session.setAttribute("justEarned", gold);
            }
        }
        return "redirect:/";
    }
    
}

