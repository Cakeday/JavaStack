package com.whatever.strings;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AThirdPage
 */
@RestController
public class AThirdPage {

    @RequestMapping("/third")
    public String third(){
        return "this is a third page thingy to return";
    }
}