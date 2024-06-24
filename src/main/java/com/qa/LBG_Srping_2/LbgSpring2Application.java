package com.qa.LBG_Srping_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class LbgSpring2Application {

	public static void main(String[] args) {
		SpringApplication.run(LbgSpring2Application.class, args);
	}
	// this method will be called when a GET request is sent to /hello
	@GetMapping("/hello")
	public String greeting() {
		return "Hello, World!";
	}
}