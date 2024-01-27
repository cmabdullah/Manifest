package com.cm.coreapplication.service;

import org.springframework.stereotype.Service;

/**
 * Created By Khan, C M Abdullah on 28/1/24 : 12:07 AM
 * REF:
 */
@Service
public class EmailServiceImpl implements EmailService {
	@Override
	public void send(String message) {
		System.out.println("Message sent. message is " + message);
	}
}
