package com.cm.application.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

/**
 * Created By Khan, C M Abdullah on 28/1/24 : 12:10 AM
 * REF:
 */
@RestController
public class HomeController {

	@GetMapping("/")
	public String hello() {
		return "Hello from backend, time" + LocalTime.now();
	}
}
