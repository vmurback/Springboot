package org.generation.blogPessoal.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioTeste {
	public Usuario usuario;
	/*
	 * Injeta um Objeto da Classe Validator, responsável pela Validação dos
	 * Atributos da Model
	 */

	@Autowired
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@BeforeEach
	public void start() {
	 usuario = new Usuario("Gonzales", "gonzales", "123456");

	}

	@Test
	public void testValidationAtributos() {

		usuario.setNome("João");
		usuario.setUsuario("011");
		usuario.setSenha("21837559");

		// Armazena a lista de Mensagens de Erros de Validação da Model
		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

		// Exibe as Mensagens de Erro se existirem
		System.out.println(violations.toString());

		// O Teste só passará se a Lista de Erros estiver vazia!
		assertTrue(violations.isEmpty());

	}
	
	@Test
	public void testValidationAtributosNulos() {

		Usuario usuarioErro = new Usuario();
		
		usuarioErro.setUsuario("Vavá");
		usuarioErro.setNome("011");
		usuarioErro.setSenha("456789623");

		// Armazena a lista de Mensagens de Erros de Validação da Model
		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuarioErro);

		// Exibe as Mensagens de Erro se existirem
		System.out.println(violations.toString());

		// O Teste só passará se a Lista de Erros estiver vazia!
		assertFalse(violations.isEmpty());

	}

}
