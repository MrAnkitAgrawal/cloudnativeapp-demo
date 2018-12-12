package com.demo.cloud.string.microservicea.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cloud.string.microservicea.domain.ApplicationConfiguration;

@RestController
public class MessageController {
	@Autowired
	ApplicationConfiguration configuration;
	
	@GetMapping("/message")
	public Map<String, String> getMessage() {
		Map<String, String> messageMap = new HashMap<>();
		messageMap.put("message", configuration.getMessage());
		return messageMap;
	}
}
