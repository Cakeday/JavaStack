package com.sample.plate.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.plate.models.Advertisement;
import com.sample.plate.models.Magazine;
import com.sample.plate.models.User;
import com.sample.plate.repositories.AdvertisementRep;
import com.sample.plate.repositories.MagazineRep;
import com.sample.plate.repositories.UserRep;
import com.sample.plate.services.AdvertisementService;
import com.sample.plate.services.MagazineService;
import com.sample.plate.services.UserService;
import com.sample.plate.validator.UserValidator;

@Controller
public class MainController {
	private final UserRep userRep;
	private final MagazineRep magazineRep;
	private final AdvertisementRep advertisementRep;
	private final UserService userService;
	private final MagazineService magazineService;
	private final AdvertisementService advertisementService;
	
    private final UserValidator userValidator;

	
	public MainController(
			UserRep userRep,
			MagazineRep magazineRep,
			AdvertisementRep advertisementRep,
			UserService userService,
			MagazineService magazineService,
			AdvertisementService advertisementService,
			UserValidator userValidator
			) {
		this.userRep = userRep;
		this.magazineRep = magazineRep;
		this.advertisementRep = advertisementRep;
		this.userService = userService;
		this.magazineService = magazineService;
		this.advertisementService = advertisementService;
        this.userValidator = userValidator;

	}
	
	
//	@GetMapping("/")
//	public String regAndLogin(@ModelAttribute("user_r") User user_r) {
//		return "logReg.jsp";
//	}
	@GetMapping("/")
	public String regAndLogin(Model model) {
		model.addAttribute("user_r", new User());
		return "logReg.jsp";
	}
	
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("user_r") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "logReg.jsp";
        }
        User u = userService.registerUser(user);
        session.setAttribute("userId", u.getId());
        return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email_l") String email, @RequestParam("password_l") String password, Model model, HttpSession session) {
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if(isAuthenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/dashboard";
		} else {
			model.addAttribute("error", "Invalid Credentials. Please try again");
			return "logReg.jsp";
		}
	}
	
	@GetMapping("/dashboard")
	public String dash(Model model, HttpSession session) {
		List<Magazine> ms = magazineRep.findAll();
		List<Advertisement> as = advertisementRep.findAll();
		User u = userService.findUserById((Long) session.getAttribute("userId"));
//		List<Object> mylist = new ArrayList<Object>();
//		for(int i = 0; i < ms.size(); i++) {
//			mylist.add(ms.get(i));
//		}for(int i = 0; i < as.size(); i++) {
//			mylist.add(as.get(i));
//		}
//		model.addAttribute("mylist", mylist);
		model.addAttribute("ms", ms);
		model.addAttribute("as", as);
		model.addAttribute("u", u);
		return "dashboard.jsp";
	}
	
	@GetMapping("/create/magazine")
	public String renderCreateMagazine(@ModelAttribute("magazine") Magazine magazine) {
		return "createMag.jsp";
	}
	
	@PostMapping("/create/magazine")
	public String createMagazine(@Valid @ModelAttribute("magazine") Magazine magazine, BindingResult result) {
		if(result.hasErrors()) {
			return "createMag.jsp";

		} else {
			magazineRep.save(magazine);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/create/advertisement")
	public String renderCreateAdvertisement(@ModelAttribute("advertisement") Advertisement advertisement) {
		return "createAd.jsp";
	}
	
	@PostMapping("/create/advertisement")
	public String createAdvertisement(@Valid @ModelAttribute("advertisement") Advertisement advertisement, BindingResult result) {
		if(result.hasErrors()) {
			return "createAd.jsp";

		} else {
			advertisementRep.save(advertisement);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/magazine/{magazine_id}/join")
	public String joinMagazine(HttpSession session, @PathVariable("magazine_id") Long id) {
		Magazine m = magazineService.findMagazineById(id);
		User u = userService.findUserById((Long) session.getAttribute("userId"));
		u.setSponsor(m);
		userRep.save(u);
		return "redirect:/dashboard";
	}
	@GetMapping("/magazine/cancel")
	public String cancel(HttpSession session) {
		User u = userService.findUserById((Long) session.getAttribute("userId"));
		u.setSponsor(null);
		userRep.save(u);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/edit/advertisement/{item_id}")
	public String editAdvertisement(@PathVariable("item_id") Long id, Model model) {
		Advertisement a = advertisementService.findAdvertisementById(id);
		model.addAttribute("advertisement", a);
		return "editAd.jsp";
	}
	@GetMapping("/show/advertisement/{item_id}")
	public String showAdvertisement(@PathVariable("item_id") Long id, Model model) {
		Advertisement a = advertisementService.findAdvertisementById(id);
		model.addAttribute("advertisement", a);
		return "showAd.jsp";
	}
	@GetMapping("/delete/advertisement/{item_id}")
	public String deleteAdvertisement(@PathVariable("item_id") Long id) {
		advertisementRep.deleteById(id);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/edit/advertisement/{item_id}")
	public String editAdvertisement(@PathVariable("item_id") Long id, @Valid @ModelAttribute("advertisement") Advertisement advertisement, BindingResult result) {
		if(result.hasErrors()) {
			return "editAd.jsp";

		} else {
			Advertisement a = advertisementService.findAdvertisementById(id);
			a.setContent(advertisement.getContent());
			a.setName(advertisement.getName());
			advertisementRep.save(a);
//			System.out.println(advertisement.getId());
//			advertisementRep.save(advertisement);
			return "redirect:/dashboard";
		}
	}
	
	
}
