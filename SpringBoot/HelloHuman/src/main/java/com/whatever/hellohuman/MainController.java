package com.whatever.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping("/")
	public String display(@RequestParam(value="firstName", required=false) String firstName, @RequestParam(value="lastName", required=false) String lastName) {
		if (firstName != null && lastName == null) {
			return "Hello " + firstName + "!";
		}
		else if (firstName != null && lastName != null) {
			return "Hello " + firstName + " " + lastName + "!";
		}
		else{
			return "Hello Human!";
		}
	}
}
