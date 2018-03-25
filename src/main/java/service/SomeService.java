package service;

import org.springframework.stereotype.Service;

@Service
public class SomeService {
	
	public String hello(String name)
	{
		return "Hello " + name;
	}
}
