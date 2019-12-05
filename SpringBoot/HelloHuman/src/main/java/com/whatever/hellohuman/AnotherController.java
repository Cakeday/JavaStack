package com.whatever.hellohuman;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnotherController {
	@RequestMapping("/")
	public String display() {
		return "index.jsp";
	}

}
