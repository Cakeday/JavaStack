package com.whatever.strings;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String home(){
		return "Hello client, how are you doing?";
	}
	
	@RequestMapping("/random")
	public String random(){
		return "Spring boot is great!";
	}
	

}
