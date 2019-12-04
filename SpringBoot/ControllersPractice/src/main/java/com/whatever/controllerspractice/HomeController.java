package com.whatever.controllerspractice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("/more")
	public String more() {
		return "more more more Hello World!";
	}

}
