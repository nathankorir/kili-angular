package com.kilifarm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professionals")
public class Professionals {

	@GetMapping("/index")
	public String index() {
		return "Home page for Machinery Owners";
	}
}
