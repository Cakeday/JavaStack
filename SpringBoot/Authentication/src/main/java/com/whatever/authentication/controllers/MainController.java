package com.whatever.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.whatever.authentication.models.User;
import com.whatever.authentication.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * MainController
 */
@Controller
public class MainController {
    
    private final UserService userService;
    
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationpage.jsp";
    }
    @GetMapping("/login")
    public String login() {
        return "loginpage.jsp";
    }
    
    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
        if(result.hasErrors()){
            return "/registration";
        } else {
            User u = userService.registerUser(user);
            session.setAttribute("userId", u.getId());
            return "redirect:/home";
        }
    }
    
    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
        boolean isAuthenticated = userService.authenticateUser(email, password);
        if (isAuthenticated) {
            User u = userService.findByEmail(email);
            session.setAttribute("userId", u.getId());
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid credentials; try again.");
            return "loginpage.jsp";
        }
        
    }
    
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
        Long userId = (Long) session.getAttribute("userId");
        User u = userService.findUserById(userId);
        model.addAttribute("user", u);
        return "homepage.jsp";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
        session.invalidate();
        return "redirect:/login";
    }
}