package com.cm.application.contoller;

import com.cm.coreapplication.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

/**
 * Created By Khan, C M Abdullah on 28/1/24 : 12:10 AM
 * REF:
 */
@RestController
public class HomeController {

	private final EmailService emailService;

	@Autowired
	public HomeController(EmailService emailService) {
		this.emailService = emailService;
	}

	@GetMapping("/")
	public String hello() {
		var message = "Hello from backend, time" + LocalTime.now();
		emailService.send(message);
		return message;
	}
}
