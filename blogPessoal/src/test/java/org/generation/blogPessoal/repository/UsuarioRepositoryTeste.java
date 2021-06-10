package org.generation.blogPessoal.repository;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTeste {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	public void start() {
	
	Usuario usuario = new Usuario("Chefe", "0y", "9xxxxxxx9");
	
	
	if (usuarioRepository.findFirstByNome(usuario.getNome()) != null) {
		usuarioRepository.save(usuario);
		
		}
	
	usuario = new Usuario("Novo Chefe", "0y", "8xxxxxxx8");
		if (usuarioRepository.findFirstByNome(usuario.getNome()) != null) {
		usuarioRepository.save(usuario); 
		}
	
	usuario = new Usuario("chefe Mais Antigo", "0y", "7xxxxxxx7");
		if (usuarioRepository.findFirstByNome(usuario.getNome()) != null) {
	usuarioRepository.save(usuario); 
		}
	
	usuario = new Usuario("Amigo", "0z", "5xxxxxxx5");
		if (usuarioRepository.findFirstByNome(usuario.getNome()) != null) {
	usuarioRepository.save(usuario);
		
			}
		}

	@Test
	public void findByNomeRetornaUsuario() throws Exception {
		Usuario usuario = usuarioRepository.findFirstByNome("Chefe");
		assertTrue(usuario.getNome().equals("Chefe"));
	}

	@Test
	public void findAllByNomeIgnoreCaseRetornaTresUsuarios() {
		List<Usuario> contatos = usuarioRepository.findAllByNomeIgnoreCaseContaining("chefe");
		assertEquals(3, contatos.size());

	}

	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();

		}
	}

