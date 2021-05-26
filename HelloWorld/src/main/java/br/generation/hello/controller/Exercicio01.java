package br.generation.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //--> Classe controladora
public class Exercicio01 {
	 
	@GetMapping("/hello01")
	public String sayHello(){
		
		return "Habilidades: Atenção aos detalhes" + "Mentalidades: Persistência";
		
		
		
		
	}
}
