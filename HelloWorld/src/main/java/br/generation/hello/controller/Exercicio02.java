package br.generation.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //--> Classe controladora
public class Exercicio02 {
	 
	@GetMapping("/hello02")
	public String sayHello(){
		
		return " Dominar o SpringTools ";
	
		}
	}		