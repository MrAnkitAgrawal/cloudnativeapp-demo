package com.demo.cloud.string.serviceconsumer.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NumberAdderController {
	private Log log = LogFactory.getLog(NumberAdderController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${number.service.url}")
	private String numberServiceURL;

	@GetMapping("/add")
	public long add() {
		long sum = 0;
		ResponseEntity<Integer[]> responseEntity = restTemplate.getForEntity(numberServiceURL, Integer[].class);
		Integer[] numbers = responseEntity.getBody();
		for (int numner : numbers) {
			sum += numner;
		}
		log.warn("Sum " + sum);
		return sum;

	}

}
