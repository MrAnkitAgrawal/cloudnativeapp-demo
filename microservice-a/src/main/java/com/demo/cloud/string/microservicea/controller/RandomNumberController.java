package com.demo.cloud.string.microservicea.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNumberController {
	private Log log = LogFactory.getLog(RandomNumberController.class);
	@GetMapping("/random")
	public List<Integer> random() {
		List<Integer> intList = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			intList.add(generateRamdomNumber());
		}
		log.warn("Returning " + intList);
		return intList;
	}

	private int generateRamdomNumber() {
		return (int) (Math.random() * 1000);
	}
}
