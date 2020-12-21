package com.ohm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ohm.controller.dto.UserRegistrationDto;
import com.ohm.service.IUserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	@Autowired
	private IUserService userService;
	
	public UserRegistrationController(IUserService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		System.out.println("Inside Model:Registration");

		return new UserRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm() {
		System.out.println("Inside Get:Registration");
		return "registration";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		System.out.println("Inside Post:Registration");

		userService.save(registrationDto);
		return "redirect:/registration?success";
	}

}
