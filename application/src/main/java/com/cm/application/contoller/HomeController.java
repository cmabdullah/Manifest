package com.cm.application.contoller;

import com.cm.coreapplication.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.jobrunr.jobs.JobId;
import org.jobrunr.scheduling.JobScheduler;

import java.time.LocalTime;

/**
 * Created By Khan, C M Abdullah on 28/1/24 : 12:10 AM
 * REF:
 */
@RestController
public class HomeController {

	private final EmailService emailService;
	private final JobScheduler jobScheduler;

	@Value("${server.port}")
	private int serverPort;

	@Autowired
	public HomeController(EmailService emailService, JobScheduler jobScheduler) {
		this.emailService = emailService;
		this.jobScheduler = jobScheduler;
	}

	@GetMapping("/")
	public String hello() {
		var message = "Hello from backend, time " + LocalTime.now() +" port : "+ serverPort;
		emailService.send(message);
		final JobId enqueuedJobId = jobScheduler.<EmailService>enqueue(myService -> emailService.send(message));
		return "Job Enqueued: " + enqueuedJobId;
	}
}
