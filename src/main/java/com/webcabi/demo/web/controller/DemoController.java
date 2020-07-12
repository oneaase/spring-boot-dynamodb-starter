package com.webcabi.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webcabi.demo.domain.model.Document;
import com.webcabi.demo.domain.repository.DocumentRepository;

@Controller
public class DemoController {
	
	@Autowired
	private DocumentRepository repository;
	
	@RequestMapping
	@ResponseBody
	public String hello() {
		
		Document doc = new Document();
		Document res = repository.save(doc);
		
		String result = "Hello, Spring Boot with DynamoDB!" +
						res.getId() + " is saved!";
		
		return result;
	}
}
