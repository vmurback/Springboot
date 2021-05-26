package br.generation.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //--> Classe controladora
public class HelloController {
	 
	@GetMapping("/hello")
	public String sayHello(){
		
		return "Olá Mundo!";
		
	}
	 

}
