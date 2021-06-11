package org.generation.blogPessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTeste {


	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private Usuario usuario;
	private Usuario usuarioupd;
	
	@BeforeAll
	public void start() {
	usuario = new Usuario("Maria", "mariajose", "44451198");
	usuarioupd = new Usuario("Maria da Silva", "mariasilva", "995467892");
	}
	
	@Test
	public void deveRealizarPostUsuarios() {
	HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuario);
	ResponseEntity<Usuario> resposta = testRestTemplate
	.exchange("/usuarios/cadastrar", HttpMethod.POST, request, Usuario.class);
	assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
	}
	
	@Disabled
	@Test
	public void deveMostrarTodosUsuarios() {
	ResponseEntity<String> resposta = testRestTemplate
	.exchange("/usuarios/", HttpMethod.GET, null, String.class);
	assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	@Disabled
	@Test
	public void deveRealizarPutUsuarios() {
	HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuarioupd);
	ResponseEntity<Usuario> resposta = testRestTemplate
	.exchange("/contatos/alterar", HttpMethod.PUT, request, Usuario.class);
	assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	@Disabled
	@Test
	public void deveRealizarDeleteUsuarios() {
	ResponseEntity<String> resposta = testRestTemplate
	.exchange("/usuarios/3", HttpMethod.DELETE, null, String.class);
	assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
}