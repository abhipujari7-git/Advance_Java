package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor of " + getClass());
	}

	@GetMapping("/")
	public String welcomeMesg() {
		System.out.println("in home page");
		return " Successfully Loaded Home page ";
	}
}
