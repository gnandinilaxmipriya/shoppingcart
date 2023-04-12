package com.shopcart.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class Sample {
	
	@GetMapping("/hello")
	public String getHello()
	{
		return "Hello peeps!";
	}

}
