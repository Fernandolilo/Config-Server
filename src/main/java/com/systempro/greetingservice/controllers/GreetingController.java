package com.systempro.greetingservice.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.systempro.greetingservice.config.GreetingConfig;
import com.systempro.greetingservice.domain.Greeting;

@RestController
public class GreetingController {
	private final AtomicLong couter = new AtomicLong();
	private static final String template = "%s, %s!" ;
	
	@Autowired
	private GreetingConfig config;
	
	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value= "name", 
			defaultValue = "")String name) {
		if(name.isEmpty()) {
			name = config.getDefaultValue();
		}
		return new Greeting(
				couter.incrementAndGet(),
				String.format(template, config.getGreeting(), name));
	}

}
