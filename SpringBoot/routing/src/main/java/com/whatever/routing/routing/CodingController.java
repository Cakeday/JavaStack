package com.whatever.routing.routing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CodingController
 */
@RestController
@RequestMapping("/coding")
public class CodingController {

    @RequestMapping("")
    public String coding(){
        return "Hello Coding Dojo!";
    }

    @RequestMapping("/python")
    public String python(){
        return "Python was awesome!";
    }

    @RequestMapping("/java")
    public String java(){
        return "Java is better!";
    }

}