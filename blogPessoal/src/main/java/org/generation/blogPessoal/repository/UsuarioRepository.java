package org.generation.blogPessoal.repository;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByUsuario(String usuario);
	
	public Usuario findFirstByNome(String nome);
	
	public List<Usuario> findAllByUsuario(String usuario);
	
	public Optional<Usuario> findAllByName(String nome);

	public List<Usuario> findAllByNomeIgnoreCaseContaining(String nome);

	public List<Usuario> findAllByUsuarioIgnoreCaseContaining(String usuario);

		
}
